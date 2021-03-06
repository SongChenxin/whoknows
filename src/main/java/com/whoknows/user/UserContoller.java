package com.whoknows.user;

import com.whoknows.domain.Picture;
import com.whoknows.domain.Tag;
import com.whoknows.domain.User;
import com.whoknows.vip.VipDetail;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserContoller {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;

	@RequestMapping(path = "/img", method = RequestMethod.POST)
	public ResponseEntity putUserPicture(@RequestParam("img") MultipartFile uploadfile) throws IOException {
		Picture picture = new Picture();
		picture.setName(uploadfile.getOriginalFilename());
		picture.setStream(uploadfile.getBytes());
		Long id = userService.addUserPicture(picture);
		if (id != null) {
			return ResponseEntity.ok(id);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	@RequestMapping(path = "/current", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity current() {
		try {
			UserDetail currentUser = userService.currentUser();
			if (currentUser != null) {
				return ResponseEntity.ok(currentUser);
			} else {
				return ResponseEntity.badRequest().build();
			}
		} catch (Exception ex) {
			return ResponseEntity.badRequest().build();
		}
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity getUserInfo(@PathVariable("id") Long id) {
		UserDetail userView = userService.getUser(id);
		if (userView != null) {
			return ResponseEntity.ok(userView);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	@RequestMapping(method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity registUser(@RequestBody User user) {
		log.info("Try to create user: {}", user == null ? "" : user.getEmail());
		if (userService.createUser(user)) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	@RequestMapping(path = "/import", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity importUserList(@RequestBody List<User> users) {
		log.info("Import users");
		if (userService.importUserList(users)) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity editUserInfo(@RequestBody UserDetail user) {
		log.info(ToStringBuilder.reflectionToString(user, ToStringStyle.MULTI_LINE_STYLE));
		if (userService.editUserInfo(user)) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	@RequestMapping(path = "/password/reset", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity resetPasswd(@RequestBody ResetPasswdMessage request) {
		log.info("Try to reset passwd: {}", request == null ? "" : request);
		if (userService.resetPasswd(request)) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	@RequestMapping(path = "/topic/{userId}/{page}", method = RequestMethod.GET)
	public ResponseEntity getUserCreateTopics(@PathVariable("userId") Long userId, @PathVariable("page") Integer page) {
		UserTopicResponse userTopicResponse = userService.getUserCreateTopics(userId, page);
		if (userTopicResponse != null) {
			return ResponseEntity.ok(userTopicResponse);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	@RequestMapping(path = "/follow/{userId}/{page}", method = RequestMethod.GET)
	public ResponseEntity getUserFollowTopics(@PathVariable("userId") Long userId, @PathVariable("page") Integer page) {
		UserTopicResponse userTopicResponse = userService.getUserFollowTopics(userId, page);
		if (userTopicResponse != null) {
			return ResponseEntity.ok(userTopicResponse);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	@RequestMapping(path = "/reply/{userId}/{page}", method = RequestMethod.GET)
	public ResponseEntity getUserReplyTopics(@PathVariable("userId") Long userId, @PathVariable("page") Integer page) {
		UserTopicResponse userTopicResponse = userService.getUserReplyTopics(userId, page);
		if (userTopicResponse != null) {
			return ResponseEntity.ok(userTopicResponse);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	@RequestMapping(path = "/home/count/into/{userId}", method = RequestMethod.GET)
	public ResponseEntity getUserCountInfo(@PathVariable("userId") Long userId) {
		UserConutInfoMessage userConutInfoResponse = userService.getUserCountInfo(userId);
		if (userConutInfoResponse != null) {
			return ResponseEntity.ok(userConutInfoResponse);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	@RequestMapping(path = "/follow/list/tag", method = RequestMethod.GET)
	public ResponseEntity getUserFollowTagList() {
		List<Tag> tags = userService.getUserFollowTagList();
		if (tags != null) {
			return ResponseEntity.ok(tags);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	@RequestMapping(path = "/follow/list/vip", method = RequestMethod.GET)
	public ResponseEntity getUserVipList() {
		List<VipDetail> vips = userService.getUserFollowVipList();
		if (vips != null) {
			return ResponseEntity.ok(vips);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
}
