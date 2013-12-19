package com.joveqiao.core.util;

import java.util.Enumeration;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;

/**
 * 类中对所有传递的参数进行处理
 * Deal with parameter.
 * @author jove
 *
 */
public class DataUtil {
	
	/**
	 * 获取页面的传入参数
	 * @param request
	 * @return 返回一个LinkedHashMap 里面是页面传入的数据
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static ModelMap getRequestParamData(HttpServletRequest request) {
		ModelMap data = new ModelMap();
		Enumeration e = request.getParameterNames();
		while (e.hasMoreElements()) {
			String key = (String) e.nextElement();
			data.put(key, request.getParameter(key));
		}
		return data;
	} 

}
