package com.joveqiao.Hexue.service.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

/**
 * 网站的通用服务类
 * 
 * @author jove
 * 
 */
@Service
public interface SiteCommonService {

	/**
	 * 验证登录
	 * 
	 * @param modelMap
	 * @return
	 */
	public boolean verifyLogin(HttpServletRequest request);

}