package com.caowei;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class MD5demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//MD5信息-摘要算法，不可逆
		String password = "admin123456";
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte[] bytes = md.digest(password.getBytes("UTF-8"));
			System.out.println(Arrays.toString(bytes));
			String mdStr = new String(bytes);
			System.out.println(mdStr);
			//a-z A-Z 0-9 / * BASE64编码
			String str = Base64.getEncoder().encodeToString(bytes);
			System.out.println(str);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
