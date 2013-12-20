package com.joveqiao.Hexue.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 实体类
 * 
 * @desc 使用代码生成器生成.
 * @date 2013/12/21
 */
@Entity
@Table(name = "user_userInfo", catalog = "Hexue")
public class Userinfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4860610431449563448L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userinfoid;
	private String loginname; // 登录名
	private String loginpwd; // 登录密码
	private String username; // 用户昵称（真实姓名）
	private String idcard;
	private String phonenum;
	private String presentaddr;

	public void setUserinfoid(Long userinfoid) {
		this.userinfoid = userinfoid;
	}

	@Column(name = "userInfoID", length = 11, nullable = false)
	public Long getUserinfoid() {
		return this.userinfoid;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	@Column(name = "loginName", length = 45, nullable = false, unique = true)
	public String getLoginname() {
		return this.loginname;
	}

	public void setLoginpwd(String loginpwd) {
		this.loginpwd = loginpwd;
	}

	@Column(name = "loginPwd", length = 40, nullable = false)
	public String getLoginpwd() {
		return this.loginpwd;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "userName", length = 45, nullable = false, unique = true)
	public String getUsername() {
		return this.username;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	@Column(name = "IDcard", length = 20, nullable = false, unique = true)
	public String getIdcard() {
		return this.idcard;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	@Column(name = "phoneNum", length = 15, nullable = false)
	public String getPhonenum() {
		return this.phonenum;
	}

	public void setPresentaddr(String presentaddr) {
		this.presentaddr = presentaddr;
	}

	@Column(name = "presentAddr", length = 45, nullable = false)
	public String getPresentaddr() {
		return this.presentaddr;
	}

}