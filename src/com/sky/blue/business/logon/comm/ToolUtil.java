package com.sky.blue.business.logon.comm;

import java.math.BigInteger;
import java.security.MessageDigest;

public class ToolUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getMD5("ycaiwudz"));
	}
	  public static String getMD5(String str) {
			String encryptStr = null;
			if (str == null) {
				return null;
			}
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(str.getBytes());
				BigInteger hash = new BigInteger(1, md.digest());
				encryptStr = hash.toString(16).toUpperCase();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return encryptStr;
		}
}
