package com.joveqiao.Hexue;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Test {

	public static void main(String[] args) {
		try {
			InetAddress ip = InetAddress.getLocalHost();
			  NetworkInterface network = NetworkInterface.getByInetAddress(ip);
			  if (network != null) {
			    byte[] mac = network.getHardwareAddress();
			    if(mac != null) {
			      System.out.print("MAC address : ");
			      StringBuilder sb = new StringBuilder();
			      for (int i = 0; i < mac.length; i++) {
			        sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));        
			      }
			      System.out.println(sb.toString());  
			   }
			  }
			} catch (UnknownHostException e) {
			  e.printStackTrace();
			} catch (SocketException e) {
			  e.printStackTrace();
			}

	}

}
