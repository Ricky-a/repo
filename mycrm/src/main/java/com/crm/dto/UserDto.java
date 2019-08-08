package com.crm.dto;

import java.util.Date;


import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 
 * @author admin
 *
 */
public class UserDto {

	private Long userId;

	/**
	 * 主动创建
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date userCreate;

	/**
	 * 被动更新
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date userModified;

	/**
	 * 登陆名
	 */
	private String userLoginname;

	/**
	 * 真实姓名
	 */
	private String userName;

	/**
	 * 锁定状态,0正常
	 */
	private String userIslocking;

	/**
	 * 身份证号
	 */
	private String useridentityCard;

	/**
	 * 性别
	 */
	private String userGender ;

	/**
	 * 手机号
	 */
	private String userMobile;

	/**
	 * 邮箱地址
	 */
	private String userEmail;

	/**
	 * 出生日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date userBirthday;

	/**
	 * 年龄
	 */
	private Integer userAge;

	public UserDto() {
		super();
	}

	public UserDto(Long userId, Date userCreate, Date userModified, String userLoginname, String userName,
			String userIslocking,  String useridentityCard, String userGender, String userMobile, String userEmail,
			Date userBirthday, Integer userAge) {
		super();
		this.userId = userId;
		this.userCreate = userCreate;
		this.userModified = userModified;
		this.userLoginname = userLoginname;
		this.userName = userName;
		this.userIslocking = userIslocking;
		this.useridentityCard = useridentityCard;
		this.userGender = userGender;
		this.userMobile = userMobile;
		this.userEmail = userEmail;
		this.userBirthday = userBirthday;
		this.userAge = userAge;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getUserCreate() {
		return userCreate;
	}

	public void setUserCreate(Date userCreate) {
		this.userCreate = userCreate;
	}

	public Date getUserModified() {
		return userModified;
	}

	public void setUserModified(Date userModified) {
		this.userModified = userModified;
	}

	public String getUserLoginname() {
		return userLoginname;
	}

	public void setUserLoginname(String userLoginname) {
		this.userLoginname = userLoginname;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserIslocking() {
		return userIslocking;
	}

	public void setUserIslocking(String userIslocking) {
		this.userIslocking = Integer.valueOf(userIslocking) > 5 ?"锁定":"正常";
	}

	public String getUseridentityCard() {
		return useridentityCard;
	}

	public void setUseridentityCard(String useridentityCard) {
		this.useridentityCard = useridentityCard;
	}

	public String getUserGender() {
		if (userGender.equals("男")) {
			return "0";
		}else if (userGender.equals("女")) {
			return "1";
		}
		return userGender;
	}

	public void setUserGender(String userGender) {	
		this.userGender = userGender.equals("0")?"男":"女";
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Date getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}

	public Integer getUserAge() {
		return userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", userCreate=" + userCreate + ", userModified=" + userModified
				+ ", userLoginname=" + userLoginname + ", userName=" + userName + ", userIslocking=" + userIslocking
				+ ", useridentityCard=" + useridentityCard + ", userGender=" + userGender + ", userMobile=" + userMobile
				+ ", userEmail=" + userEmail + ", userBirthday=" + userBirthday + ", userAge=" + userAge + "]";
	}

}
