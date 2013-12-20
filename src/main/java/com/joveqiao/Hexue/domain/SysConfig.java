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
@Table(name = "sys_config", catalog = "Hexue")
public class SysConfig implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3253774520691029757L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long configid;
	private String configname; // 配置表，这里主要放工价 元/小时 configName = hourlyWage 取最新值
	private Double configval;

	public void setConfigid(Long configid) {
		this.configid = configid;
	}

	@Column(name = "configID", length = 11, nullable = false)
	public Long getConfigid() {
		return this.configid;
	}

	public void setConfigname(String configname) {
		this.configname = configname;
	}

	@Column(name = "configName", length = 15, nullable = false)
	public String getConfigname() {
		return this.configname;
	}

	public void setConfigval(Double configval) {
		this.configval = configval;
	}

	@Column(name = "configVal", nullable = false)
	public Double getConfigval() {
		return this.configval;
	}

}