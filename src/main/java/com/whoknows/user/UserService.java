package com.whoknows.user;

import com.whoknows.domain.User;
import com.whoknows.framework.TopicView;
import com.whoknows.framework.UserView;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserRepository userRepository;

	public UserView getUserInfo(Long id) {
		if (id == null) {
			return null;
		}

		try {
			UserView userView = new UserView();
			userView.setUser(userRepository.getUserInfo(id));
			return userView;
		} catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
	}

	public List<TopicView> getUserTopic(Long id) {
		if (id == null) {
			return null;
		}

		try {
			return userRepository.getUserTopic(id).stream().map(topic -> {
				TopicView topicView = new TopicView();
				topicView.setTopic(topic);
				return topicView;
			}).collect(Collectors.toList());
		} catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
	}
	
	public boolean createUser(User user){
		if(StringUtils.isEmpty(user.getEmail()) && StringUtils.isEmpty(user.getPasswd())){
			return false;
		}
		try{
			userRepository.createUser(user);
			log.info("Create user :{} success.", user.getEmail());
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
}
