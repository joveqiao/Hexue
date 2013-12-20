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
@Table(name = "sys_loginInfo", catalog = "Hexue")
public class SysLogininfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6241653616665567384L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long logininfoid;
	private String loginip; // 登录时IP地址
	private String browser; // 所使用浏览器
	private String os; // 使用操作系统类型
	private String logresult; // 登录结果： '1' 登录成功; '0' 帐号存在，密码错误; '2' 帐号不存在
	private String trypwd; // 尝试密码
	private String tryloginname; // 登录者尝试登录名

	public void setLogininfoid(Long logininfoid) {
		this.logininfoid = logininfoid;
	}

	@Column(name = "loginInfoID", length = 11, nullable = false)
	public Long getLogininfoid() {
		return this.logininfoid;
	}

	public void setLoginip(String loginip) {
		this.loginip = loginip;
	}

	@Column(name = "loginIP", length = 20, nullable = false)
	public String getLoginip() {
		return this.loginip;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	@Column(name = "browser", length = 20)
	public String getBrowser() {
		return this.browser;
	}

	public void setOs(String os) {
		this.os = os;
	}

	@Column(name = "os", length = 50)
	public String getOs() {
		return this.os;
	}

	public void setLogresult(String logresult) {
		this.logresult = logresult;
	}

	@Column(name = "logResult", length = 1, nullable = false)
	public String getLogresult() {
		return this.logresult;
	}

	public void setTrypwd(String trypwd) {
		this.trypwd = trypwd;
	}

	@Column(name = "tryPwd", length = 40, nullable = false)
	public String getTrypwd() {
		return this.trypwd;
	}

	public void setTryloginname(String tryloginname) {
		this.tryloginname = tryloginname;
	}

	@Column(name = "tryLoginName", length = 45, nullable = false)
	public String getTryloginname() {
		return this.tryloginname;
	}

}