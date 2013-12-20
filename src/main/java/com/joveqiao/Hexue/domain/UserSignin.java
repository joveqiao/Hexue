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
@Table(name = "user_signin", catalog = "Hexue")
public class UserSignin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7638596939271333016L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long signinid;
	private Long fkUserinfo;
	private java.util.Date date; // 日期
	private java.util.Date cometime; // 来签到的时间
	private java.util.Date leavetime; // 离开签到的时间
	private Double moneytime; // 算钱的时间（h) 1.5 = 1h 30min
	private Double ownmoney; // 此条签到应得工资
	private String makesure; // 是否确定，确定后不可更改0 未确定 1 确定
	private String ispay; // 是否支付，0 未支付 1 支付
	private java.util.Date paytime; // 支付的时间

	public void setSigninid(Long signinid) {
		this.signinid = signinid;
	}

	@Column(name = "signinID", length = 11, nullable = false)
	public Long getSigninid() {
		return this.signinid;
	}

	public void setFkUserinfo(Long fkUserinfo) {
		this.fkUserinfo = fkUserinfo;
	}

	@Column(name = "FK_userInfo", length = 11, nullable = false)
	public Long getFkUserinfo() {
		return this.fkUserinfo;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}

	@javax.persistence.Temporal(javax.persistence.TemporalType.DATE)
	@Column(name = "date", nullable = false)
	public java.util.Date getDate() {
		return this.date;
	}

	public void setCometime(java.util.Date cometime) {
		this.cometime = cometime;
	}

	@javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@Column(name = "comeTime")
	public java.util.Date getCometime() {
		return this.cometime;
	}

	public void setLeavetime(java.util.Date leavetime) {
		this.leavetime = leavetime;
	}

	@javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@Column(name = "leaveTime")
	public java.util.Date getLeavetime() {
		return this.leavetime;
	}

	public void setMoneytime(Double moneytime) {
		this.moneytime = moneytime;
	}

	@Column(name = "moneyTime", nullable = false)
	public Double getMoneytime() {
		return this.moneytime;
	}

	public void setOwnmoney(Double ownmoney) {
		this.ownmoney = ownmoney;
	}

	@Column(name = "ownMoney", nullable = false)
	public Double getOwnmoney() {
		return this.ownmoney;
	}

	public void setMakesure(String makesure) {
		this.makesure = makesure;
	}

	@Column(name = "makesure", length = 1, nullable = false)
	public String getMakesure() {
		return this.makesure;
	}

	public void setIspay(String ispay) {
		this.ispay = ispay;
	}

	@Column(name = "isPay", length = 1, nullable = false)
	public String getIspay() {
		return this.ispay;
	}

	public void setPaytime(java.util.Date paytime) {
		this.paytime = paytime;
	}

	@javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@Column(name = "PayTime")
	public java.util.Date getPaytime() {
		return this.paytime;
	}

}