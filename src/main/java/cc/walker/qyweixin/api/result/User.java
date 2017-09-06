package cc.walker.qyweixin.api.result;

import java.util.List;

import cc.walker.qyweixin.api.req.UserExtattr;

/**
 * 用户类
 * @author walker
 * @date 2016-09-07
 */
public class User {

	private String userid;
	private String name;
	private List<Integer> department;
	private String position;
	private String mobile;
	private Integer gender;
	private String email;
	private String weixinid;
	private String avatar_mediaid;
	private Integer status;
	private UserExtattr extattr;
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Integer> getDepartment() {
		return department;
	}

	public void setDepartment(List<Integer> department) {
		this.department = department;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWeixinid() {
		return weixinid;
	}

	public void setWeixinid(String weixinid) {
		this.weixinid = weixinid;
	}

	public String getAvatar_mediaid() {
		return avatar_mediaid;
	}

	public void setAvatar_mediaid(String avatar_mediaid) {
		this.avatar_mediaid = avatar_mediaid;
	}

	public UserExtattr getExtattr() {
		return extattr;
	}

	public void setExtattr(UserExtattr extattr) {
		this.extattr = extattr;
	}

}
