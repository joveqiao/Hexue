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
@Table(name = "user_wage", catalog = "Hexue")
public class UserWage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1368575399597700065L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long wageid;

	public void setWageid(Long wageid) {
		this.wageid = wageid;
	}

	@Column(name = "wageID", length = 11, nullable = false)
	public Long getWageid() {
		return this.wageid;
	}

}