package com.joveqiao.Hexue;

import java.io.IOException;
import java.net.InetAddress;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.joveqiao.core.util.DataUtil;
import com.joveqiao.core.util.IPUtil;
import com.joveqiao.core.util.MacAddress;

@Controller
@RequestMapping(value="/site")
public class SiteCommon {
	
	
	/**
	 * 用户登录
	 * @param request
	 * @param response
	 * @param modelMap
	 * @return
	 * @throws SQLException 
	 */
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap) throws SQLException{
		modelMap = DataUtil.getRequestParamData(request);
		String ip = IPUtil.getRemoteIpAddr(request);
		System.out.println(ip);
		String xip = request.getRemoteAddr();
		System.out.println(xip);
		return new ModelAndView("in", modelMap);
	}
	
	/**
	 * 404异常页面
	 * @return
	 */
	@RequestMapping(value="/404")
	public ModelAndView notFound(){
		return new ModelAndView("404");
	}
	
	/**
	 * 500异常页面
	 * @return
	 */
	@RequestMapping(value="/500")
	public ModelAndView siteError(){
		return new ModelAndView("500");
	}
	

}
