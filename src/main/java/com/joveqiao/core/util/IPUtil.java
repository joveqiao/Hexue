package com.joveqiao.core.util;

import javax.servlet.http.HttpServletRequest;

public class IPUtil {

	/**
	 * 通过request获取客户端IP真实IP地址
	 * 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址
	 * @param request
	 * @return
	 */
	public final static String getRemoteIpAddr(HttpServletRequest request) {
		
		String ip = request.getHeader("X-Forwarded-For");

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("WL-Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("HTTP_CLIENT_IP");
			}
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("HTTP_X_FORWARDED_FOR");
			}
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getRemoteAddr();
			}
		} else if (ip.length() > 15) {
			String[] ips = ip.split(",");
			for (int index = 0; index < ips.length; index++) {
				String strIp = (String) ips[index];
				if (!("unknown".equalsIgnoreCase(strIp))) {
					ip = strIp;
					break;
				}
			}
		}
		return ip;
	}
	
	/**
	 * 返回一个byte数组的IP地址
	 * @param request
	 * @return
	 */
	public final static byte[] getRemoteIpAddrByte(HttpServletRequest request){
		String ip = getRemoteIpAddr(request);
		String[] temp = ip.split(".");
		byte[] IPbyte = new byte[temp.length];
		for(int i = 0; i < temp.length; i++){
			IPbyte[i]=Byte.parseByte(temp[i]);
		}
		return IPbyte;
	}
}
