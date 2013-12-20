package com.joveqiao.Hexue.service.common.impl;

import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.joveqiao.Hexue.dao.common.SysLogininfoDao;
import com.joveqiao.Hexue.dao.common.UserinfoDao;
import com.joveqiao.Hexue.domain.SysLogininfo;
import com.joveqiao.Hexue.service.common.SiteCommonService;
import com.joveqiao.core.util.DataUtil;
import com.joveqiao.core.util.IPUtil;

@Service
public class SiteCommonServiceImpl implements SiteCommonService {

	@Autowired
	private UserinfoDao userinfoDao;

	@Autowired
	private SysLogininfoDao sysLogininfoDao;

	public boolean verifyLogin(HttpServletRequest request) {
		ModelMap modelMap = DataUtil.getRequestParamData(request);
		String userName = modelMap.get("userName").toString();
		String userPwd = modelMap.get("userPwd").toString();
		List list = userinfoDao.findByLoginnameAndLoginpwd(userName, userPwd);

		// 操作记录登录信息
		SysLogininfo sysLogininfo = new SysLogininfo();
		String userAgent = request.getHeader("User-Agent").toLowerCase();
		StringTokenizer st = new StringTokenizer(userAgent, ";");
		String accBrowser = st.nextToken().trim();
		String accOs = st.nextToken().trim();
		if (accOs.length() > 40) {
			accOs = accOs.substring(0, 40);
		}
		sysLogininfo.setBrowser(accBrowser);
		sysLogininfo.setLoginip(IPUtil.getRemoteIpAddr(request));
		sysLogininfo.setOs(accOs);
		sysLogininfo.setTryloginname(userName);
		sysLogininfo.setTrypwd(userPwd);

		boolean result = false;
		if (!list.isEmpty()) {
			sysLogininfo.setLogresult("1");
			result = true;
		} else {
			sysLogininfo.setLogresult("0");
		}

		sysLogininfoDao.save(sysLogininfo);

		return result;

	}
}
