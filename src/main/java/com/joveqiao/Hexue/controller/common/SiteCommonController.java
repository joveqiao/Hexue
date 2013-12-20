package com.joveqiao.Hexue.controller.common;

import java.io.IOException;
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

import com.joveqiao.Hexue.service.common.SiteCommonService;
import com.joveqiao.core.util.VerifyCodeUtils;

@Controller
@RequestMapping(value = "/site")
public class SiteCommonController {

	@Autowired
	private SiteCommonService siteCommonService;

	/**
	 * 用户进入登录
	 * 
	 * @param request
	 * @param response
	 * @param modelMap
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginpage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap)
			throws SQLException {
		return new ModelAndView("login", modelMap);
	}

	/**
	 * 登录
	 * 
	 * @param request
	 * @param response
	 * @param modelMap
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap)
			throws SQLException {

		if (siteCommonService.verifyLogin(request)) {

			return new ModelAndView("syshome", modelMap);
		}
		modelMap.put("verifyLogin", "0");
		return new ModelAndView("login", modelMap);
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView welcomepage(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap)
			throws SQLException {
		return new ModelAndView("welcome", modelMap);
	}

	/**
	 * 404异常页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/404")
	public ModelAndView notFound() {
		return new ModelAndView("404");
	}

	/**
	 * 500异常页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/500")
	public ModelAndView siteError() {
		return new ModelAndView("500");
	}

	/**
	 * 验证码图片生成
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/verifyImage")
	@ResponseBody
	public void getVerifyImage(HttpServletRequest request, HttpServletResponse response) {

		try {
			VerifyCodeUtils.getVerifyCode(request, response, 4, 80, 30);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
