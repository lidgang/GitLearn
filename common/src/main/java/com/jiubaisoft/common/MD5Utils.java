package com.jiubaisoft.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 描述：将指定字符串进行MD5加密处理，返回加密好的内容
 *
 * @author lidagang
 *
 * @ClassName:  com.frame.library.common.file.MD5Utils
 *
 * @date 16/01/15 14:40
 *
 */
public class MD5Utils {
	public static String Md5(String str) {
		if (str != null && !str.equals("")) {
			try {
				MessageDigest md5 = MessageDigest.getInstance("MD5");
				char[] HEX = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
				byte[] md5Byte = md5.digest(str.getBytes("UTF8"));
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < md5Byte.length; i++) {
					sb.append(HEX[(int) (md5Byte[i] & 0xff) / 16]);
					sb.append(HEX[(int) (md5Byte[i] & 0xff) % 16]);
				}
				str = sb.toString();
			} catch (NoSuchAlgorithmException e) {
			} catch (Exception e) {
			}
		}
		return str;
	}
	
}
