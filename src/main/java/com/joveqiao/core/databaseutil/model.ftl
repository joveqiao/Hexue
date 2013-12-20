<#-- TODO 改为实际使用的包名 -->
package com.joveqiao.Hexue.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

/**
 * 实体类
 * @desc	使用代码生成器生成.
 * @date 	${.now?string("yyyy/MM/dd")}
 */
@Entity
@Table(name = "${tableName}" ,catalog = "Hexue")
public class ${className} implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	<#list columns as column>
	<#assign autograph = "private " + column.propertyType + " " + column.propertyName + " ;">
	<#if column.propertyName != "id">
	${autograph}<#if (column.columnComment?? && column.columnComment?length > 0)><#if (autograph?length < 4)>${"\t\t\t\t\t\t\t\t\t\t"}<#elseif (autograph?length < 8)>${"\t\t\t\t\t\t\t\t\t"}<#elseif (autograph?length < 12)>${"\t\t\t\t\t\t\t\t"}<#elseif (autograph?length < 16)>${"\t\t\t\t\t\t\t"}<#elseif (autograph?length < 20)>${"\t\t\t\t\t\t"}<#elseif (autograph?length < 24)>${"\t\t\t\t\t"}<#elseif (autograph?length < 28)>${"\t\t\t\t"}<#elseif (autograph?length < 32)>${"\t\t\t"}<#elseif (autograph?length < 36)>${"\t\t"}<#else>${"\t"}</#if>// ${column.columnComment}</#if>
	</#if>
	</#list>	

	<#list columns as column>
	<#if column.propertyName != "id">
	public void set${column.propertyName?cap_first} (${column.propertyType} ${column.propertyName}){
		this.${column.propertyName} = ${column.propertyName} ;
	}
	<#if column.propertyType == "java.util.Date">@javax.persistence.Temporal(javax.persistence.TemporalType<#if column.columnType == "DATE" || column.columnType == "date">.DATE<#else>.TIMESTAMP</#if>)</#if>
	@Column(name = "${column.columnName}"<#if column.columnSize != 0> ,length = ${column.columnSize}</#if><#if column.isNullable == "NO"> ,nullable = false</#if><#if column.columnKey == "UNI"> ,unique = true</#if>)	
	public ${column.propertyType} get${column.propertyName?cap_first} (){
		return this.${column.propertyName} ;
	}
	
	</#if>
	</#list>	

}