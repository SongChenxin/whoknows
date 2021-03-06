package com.whoknows.app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "wk.pageContentConfig")
public class ConfigProperties {

	private Map<String, String> properties = new HashMap<String, String>();

	public ConfigProperties() {
		properties.put("aboutUs", "<h2>联系我们</h2><hr><p>Who Knows是一个真实的网络问答社区，社区氛围友好与理性，连接各行各业的精英。用户分享着彼此的专业知识、经验和见解，为中文互联网源源不断地提供高质量的信息。</p><p>公司名称：Who knows<br>地址：中国上海<br>邮编：200131 <br>电话：+86 (21) 8888-1111 (总机) <br>传真：+86 (21) 8888-1000 <br></p>");
	}

	public Map<String, String> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}

}
