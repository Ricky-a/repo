package com.crm.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 用户信息表
 * 
 * @author admin
 *
 */
public class UserPo {

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
	private Integer userIslocking;

	/**
	 * 身份证号
	 */
	private String useridentityCard;

	/**
	 * 性别
	 */
	private Integer userGender;

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

	/**
	 * 非0为失效数据
	 */
	private Integer userFlag;

	/**
	 * 密码
	 */
	private String userPassword;

	public UserPo() {
		super();
	}

	public UserPo(Long userId, Date userCreate, Date userModified, String userLoginname, String userName,
			Integer userIslocking, String useridentityCard, Integer userGender, String userMobile, String userEmail,
			Date userBirthday, Integer userAge, Integer userFlag, String userPassword) {
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
		this.userFlag = userFlag;
		this.userPassword = userPassword;
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

	public Integer getUserIslocking() {
		return userIslocking;
	}

	public void setUserIslocking(Integer userIslocking) {
		this.userIslocking = userIslocking;
	}

	public String getUseridentityCard() {
		return useridentityCard;
	}

	public void setUseridentityCard(String useridentityCard) {
		this.useridentityCard = useridentityCard;
	}

	public Integer getUserGender() {
		return userGender;
	}

	public void setUserGender(Integer userGender) {
		this.userGender = userGender;
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

	public Integer getUserFlag() {
		return userFlag;
	}

	public void setUserFlag(Integer userFlag) {
		this.userFlag = userFlag;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "UserPo [userId=" + userId + ", userCreate=" + userCreate + ", userModified=" + userModified
				+ ", userLoginname=" + userLoginname + ", userName=" + userName + ", userIslocking=" + userIslocking
				+ ", useridentityCard=" + useridentityCard + ", userGender=" + userGender + ", userMobile=" + userMobile
				+ ", userEmail=" + userEmail + ", userBirthday=" + userBirthday + ", userAge=" + userAge + ", userFlag="
				+ userFlag + ", userPassword=" + userPassword + "]";
	}

}
