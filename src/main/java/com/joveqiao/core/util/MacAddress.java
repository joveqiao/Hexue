package com.joveqiao.core.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author hyq jdk1.4下获取mac地址
 */
public class MacAddress {

	/**
	 * jdk1.6下API获取mac地址 推荐使用
	 * 
	 * @return
	 */
	public static String getMAC() {
		Enumeration<NetworkInterface> el;
		String mac_s = "";
		try {
			el = NetworkInterface.getNetworkInterfaces();
			while (el.hasMoreElements()) {
				byte[] mac = el.nextElement().getHardwareAddress();
				if (mac == null)
					continue;
				mac_s = hexByte(mac[0]) + "-" + hexByte(mac[1]) + "-"
						+ hexByte(mac[2]) + "-" + hexByte(mac[3]) + "-"
						+ hexByte(mac[4]) + "-" + hexByte(mac[5]);
				// System.out.println(mac_s);
			}
		} catch (SocketException e1) {
			e1.printStackTrace();
		}
		return mac_s;
	}

	public static final String hexByte(byte buf) {
		String tmp = "";
		tmp = Integer.toHexString(0xff & buf);
		tmp = tmp.length() == 1 ? "0" + tmp : tmp;
		return tmp;
	}
	
	/**
	 * 通過遠程IP獲取遠程mac地址
	 * @param ip
	 * @return
	 */
	public static String getMAC(String ip,String host) {
		
		String[] temp = ip.trim().split("\\.");
		byte[] IPbyte = new byte[temp.length];
		for(int i = 0; i < temp.length; i++){
			int tempIP = Integer.parseInt(temp[i]);
			if(tempIP>127){
				IPbyte[i]= (byte) (tempIP - 256) ;
			}else{
				IPbyte[i] =(byte) tempIP ;
			}
		}
		
		try {
			InetAddress netAddress = InetAddress.getByAddress(IPbyte);
			NetworkInterface network = NetworkInterface.getByInetAddress(netAddress);
			System.out.println(network);
			if (network != null) {
				byte[] mac = network.getHardwareAddress();
				if (mac != null) {
					System.out.print("MAC address : ");
					StringBuilder sb = new StringBuilder();
					for (int i = 0; i < mac.length; i++) {
						sb.append(String.format("%02X%s", mac[i],
								(i < mac.length - 1) ? "-" : ""));
					}
					return sb.toString();
				}
			}
			System.out.println("getMAC 失敗，無法獲取NETwork");
			return null;
		} catch (UnknownHostException e) {
			  e.printStackTrace();
			  return null;
		} catch (SocketException e) {
		  e.printStackTrace();
		  return null;
		}
	}

	/**
	 * 获取当前操作系统名称. return 操作系统名称 例如:windows,Linux,Unix等.
	 */
	public static String getOSName() {
		return System.getProperty("os.name").toLowerCase();
	}

	/**
	 * 获取Unix网卡的mac地址.
	 * 
	 * @return mac地址
	 */
	public static String getUnixMACAddress() {
		String mac = null;
		BufferedReader bufferedReader = null;
		Process process = null;
		try {
			// Unix下的命令，一般取eth0作为本地主网卡 显示信息中包含有mac地址信息
			process = Runtime.getRuntime().exec("ifconfig eth0");
			bufferedReader = new BufferedReader(new InputStreamReader(
					process.getInputStream()));
			String line = null;
			int index = -1;
			while ((line = bufferedReader.readLine()) != null) {
				// 寻找标示字符串[hwaddr]
				index = line.toLowerCase().indexOf("hwaddr");
				if (index != -1) {
					// 取出mac地址并去除2边空格
					mac = line.substring(index + "hwaddr".length() + 1).trim();
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			bufferedReader = null;
			process = null;
		}

		return mac;
	}

	/**
	 * 获取Linux网卡的mac地址
	 * 
	 * @return mac地址
	 */
	public static String getLinuxMACAddress() {
		String mac = null;
		BufferedReader bufferedReader = null;
		Process process = null;
		try {
			// linux下的命令，一般取eth0作为本地主网卡 显示信息中包含有mac地址信息
			process = Runtime.getRuntime().exec("ifconfig eth0");
			bufferedReader = new BufferedReader(new InputStreamReader(
					process.getInputStream()));
			String line = null;
			int index = -1;
			while ((line = bufferedReader.readLine()) != null) {
				index = line.toLowerCase().indexOf("硬件地址");
				if (index != -1) {
					// 取出mac地址并去除2边空格
					mac = line.substring(index + 4).trim();
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			bufferedReader = null;
			process = null;
		}

		return mac;
	}

	/**
	 * 获取widnowXp网卡的mac地址.
	 * 
	 * @return mac地址
	 */
	public static String getWindowXPMACAddress(String execStr) {
		String mac = null;
		BufferedReader bufferedReader = null;
		Process process = null;
		try {

			// windows下的命令，显示信息中包含有mac地址信息
			process = Runtime.getRuntime().exec(execStr);
			bufferedReader = new BufferedReader(new InputStreamReader(
					process.getInputStream()));
			String line = null;
			int index = -1;
			while ((line = bufferedReader.readLine()) != null) {
				if (line.indexOf("本地连接") != -1) // 排除有虚拟网卡的情况
					continue;

				// 寻找标示字符串[physical address]
				index = line.toLowerCase().indexOf("physical address");
				if (index != -1) {
					index = line.indexOf(":");
					if (index != -1) {
						// 取出mac地址并去除2边空格
						mac = line.substring(index + 1).trim();
					}
					break;
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			bufferedReader = null;
			process = null;
		}

		return mac;
	}

	/**
	 * 获取widnow7网卡的mac地址.
	 * 
	 * @return mac地址
	 */
	public static String getWindow7MACAddress(String execStr) {
		String mac = null;
		BufferedReader bufferedReader = null;
		Process process = null;
		try {

			process = Runtime.getRuntime().exec(execStr);
			bufferedReader = new BufferedReader(new InputStreamReader(
					process.getInputStream()));
			String line = null;
			int index = -1;
			while ((line = bufferedReader.readLine()) != null) {
				index = line.toLowerCase().indexOf("物理地址");
				if (index != -1) {
					index = line.indexOf(":");
					if (index != -1) {
						mac = line.substring(index + 1).trim();
					}
					break;
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			bufferedReader = null;
			process = null;
		}

		return mac;
	}

	/**
	 * 获取MAC地址 不推荐使用。请使用 getMAC()
	 */
	public static String getMacAddress() {
		String os = getOSName();
		String execStr = getSystemRoot() + "/system32/ipconfig /all";
		String mac = null;
		if (os.startsWith("windows")) {
			if (os.equals("windows xp")) { // xp
				mac = getWindowXPMACAddress(execStr);
			} else if (os.equals("windows 2003")) { // 2003
				mac = getWindowXPMACAddress(execStr);
			} else { // win7
				mac = getWindow7MACAddress(execStr); // B8-70-F4-49-2B-EE
			}

		} else if (os.startsWith("linux")) {
			mac = getLinuxMACAddress();
		} else {
			mac = getUnixMACAddress();
		}
		return mac;
	}

	/**
	 * jdk1.4获取系统命令路径 ：SystemRoot=C:\WINDOWS
	 * 
	 * @return
	 */
	public static String getSystemRoot() {
		String cmd = null;
		String os = null;
		String result = null;
		String envName = "windir";

		os = System.getProperty("os.name").toLowerCase();

		if (os.startsWith("windows")) {
			cmd = "cmd /c SET";
		} else {
			cmd = "env";
		}

		try {
			Process p = Runtime.getRuntime().exec(cmd);
			InputStreamReader isr = new InputStreamReader(p.getInputStream());
			BufferedReader commandResult = new BufferedReader(isr);
			String line = null;
			while ((line = commandResult.readLine()) != null) {
				if (line.indexOf(envName) > -1) {
					result = line.substring(line.indexOf(envName)
							+ envName.length() + 1);
					return result;
				}
			}
		} catch (Exception e) {
			System.out.println("获取系统命令路径 error: " + cmd + ":" + e);
		}
		return null;
	}

	/* public static void main(String[] args) throws UnknownHostException {
	 //System.out.println("mac地址为： "+getMacAddress());

		 InetAddress ip = InetAddress.getLocalHost();
		 System.out.println(ip);
		 System.out.println("mac地址为： "+getMAC(ip));
	}*/

}