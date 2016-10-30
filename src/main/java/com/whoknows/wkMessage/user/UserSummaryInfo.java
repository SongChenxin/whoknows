package com.whoknows.wkMessage.user;

import java.sql.Timestamp;
import java.util.List;

import com.whoknows.domain.Role;
import com.whoknows.domain.User;
import com.whoknows.domain.Vip;

public class UserSummaryInfo {

	private Long id;
	private String email;
	private String phone;
	private String firstName;
	private String lastName;
	private String companyName;
	private String province;
	private String city;
	private String address;
	private Timestamp createTime;
	private Boolean vip;
	private String picture;
	private String education;
	private Long signatureId;
	private String title;

	private List<Role> roles;
	private Vip vipInfo;

	public Vip getVipInfo() {
		return vipInfo;
	}

	public void setVipInfo(Vip vipInfo) {
		this.vipInfo = vipInfo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Boolean getVip() {
		return vip;
	}

	public void setVip(Boolean vip) {
		this.vip = vip;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public Long getSignatureId() {
		return signatureId;
	}

	public void setSignatureId(Long signatureId) {
		this.signatureId = signatureId;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setUser(User user, List<Role> roles) {
		this.id = user.getId();
		this.email = user.getEmail();
		this.phone = user.getPhone();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.companyName = user.getCompanyName();
		this.province = user.getProvince();
		this.city = user.getCity();
		this.address = user.getAddress();
		this.createTime = user.getCreateTime();
		this.vip = user.getVip();
		this.picture = user.getPicture();
		this.education = user.getEducation();
		this.signatureId = user.getSignatureId();
		this.roles = roles;
		this.title = user.getTitle();
	}
}