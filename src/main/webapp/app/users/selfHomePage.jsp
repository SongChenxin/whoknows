<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container self-home-page">

      <div class="row row-offcanvas row-offcanvas-right">

        <div class="col-xs-12 col-sm-9">
          <div class="row self-info">
          	<div class="col-xs-6 col-sm-3">
          		<img alt="" src="../../images/selfPicture/2.png"></img>
          	</div>
          	<div class="col-xs-12 col-sm-9">
          		<h1>{{user.email}}</h1>
          		<dl class="dl-horizontal">
				  <dt>目前就职</dt>
				  <dd><span ng-hide= "showCompanyEdit">{{user.companyName}}</span>
				  		<a href="javascript:void(0)" ng-click="showEditCompany()" ng-hide= "showCompanyEdit" ng-if="user.companyName == undefined || user.companyName == null">填写公司信息</a>
				  		<div class="form-group" ng-show="showCompanyEdit">
						    <div class="col-sm-6">
						      <input type="text" required class="form-control login-email-input"  ng-model = "user.companyName" placeholder="公司信息" >
						    </div>
						    	<div class="col-lg-2"> 
						    		<button type="submit" class="btn btn-primary text-center" ng-click="saveUserInfo('companyName')">保存</button>
						    	</div>
				  		</div>
				  </dd>
				  <dt>目前职位</dt>
				  <dd><span ng-hide="showTitleEdit">{{user.title}}</span>
				  		<a href="javascript:void(0)" ng-click="showEditTitle()" ng-hide="showTitleEdit" ng-if="user.title == undefined || user.title == null">填写职位信息</a>
				  		<div class="form-group" ng-show="showTitleEdit">
						    <div class="col-sm-6">
						      <input type="text" required class="form-control login-email-input"  ng-model = "user.title" placeholder="职位信息" >
						    </div>
						    	<div class="col-lg-2"> 
						    		<button type="submit" class="btn btn-primary text-center" ng-click="saveUserInfo('title')">保存</button>
						    	</div>
				  		</div>
				  </dd>
				  <dt>教育信息</dt>
				  <dd><span ng-hide="showEduEdit" >{{user.education}}</span>
				  		<a href="javascript:void(0)" ng-click="showEditEdu()" ng-hide="showEduEdit" ng-if="user.education == undefined || user.education == null">填写教育信息</a>
				  		<div class="form-group" ng-show="showEduEdit">
						    <div class="col-sm-6">
						      <input type="text" required class="form-control login-email-input"  ng-model = "user.education" placeholder="教育信息" >
						    </div>
						    	<div class="col-lg-2"> 
						    		<button type="submit" class="btn btn-primary text-center" ng-click="saveUserInfo('education')">保存</button>
						    	</div>
				  		</div>
				  </dd>
				  <dt>我的签名</dt>
				  <dd><span ng-hide="showSinEdit">{{user.signature}}</span>
				  		<a href="javascript:void(0)" ng-click="showEditSin()" ng-hide="showSinEdit" ng-if="user.signature == undefined || user.signature == null">填写签名信息</a>
				  		<div class="form-group" ng-show="showSinEdit">
						    <div class="col-sm-6">
						    		<textarea class="form-control" required rows="2" ng-model="user.signature"></textarea>
						    </div>
						    	<div class="col-lg-2"> 
						    		<button type="submit" class="btn btn-primary text-center" ng-click="saveUserInfo('signature')">保存</button>
						    	</div>
				  		</div>
				  </dd>
				</dl>
          	</div>
          </div>
          <div class="row">
          	<ul id="self-home-page-tab" class="nav nav-tabs">
			    <li class="active">
			    		<a data-target="#attention-question" ng-click="myFllowTopic()" data-toggle="tab">关注的问题 <span class="badge ng-cloak">{{contInfo.followCount}}</span></a>
			    </li>
			    <li><a data-target="#my-question" data-toggle="tab" ng-click="myTopic()">我的提问 <span class="badge ng-cloak">{{contInfo.createTopicCount}}</span></a></li>
			    <li><a data-target="#my-answer" data-toggle="tab" ng-click="myReply()">我的问答 <span class="badge ng-cloak">{{contInfo.replyCount}}</span></a></li>
			</ul>
			<div id="myTabContent" class="tab-content">
			    <div class="tab-pane fade in active" id="attention-question">
			    		<topic-list topic-lists="topicLists" hide-read-more="hideReadMore" load-more-data="loadMore()" refresh-follow-count ="loadCountInfo()"></topic-list>
			    </div>
			    <div class="tab-pane fade" id="my-question">
			   	 	<topic-list topic-lists="topicLists" hide-read-more="hideReadMore" load-more-data="loadMore()" refresh-follow-count ="loadCountInfo()"></topic-list>
			    </div>
			    <div class="tab-pane fade" id="my-answer">
			        <topic-list topic-lists="topicLists" hide-read-more="hideReadMore" load-more-data="loadMore()" refresh-follow-count ="loadCountInfo()"></topic-list>
			    </div>
			</div>
          </div><!--/row-->
        </div><!--/.col-xs-12.col-sm-9-->

        <div class="col-xs-6 col-sm-3 sidebar-offcanvas" role="navigation">
          <hot-tag-siderbar topic="ttttopic"></hot-tag-siderbar>
		  <hot-superstar-siderbar star="str"></hot-superstar-siderbar>
        </div><!--/.sidebar-offcanvas-->
      </div><!--/row-->

 </div>