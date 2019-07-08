package com.jiubaisoft.common;

import android.annotation.SuppressLint;
import android.util.Base64;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * base64解析
 * 
 * @author songdehuai
 *
 */
public class Base64Utils {

	/**
	 * encodeBase64File:(将文件转成base64 字符串). <br/>
	 * @author song
	 * @param path
	 *            文件路径
	 * @return
	 * @throws Exception
	 */
	@SuppressLint("NewApi")
	public static String encodeBase64File(String path) throws Exception {
		File file = new File(path);
		FileInputStream inputFile = new FileInputStream(file);
		byte[] buffer = new byte[(int) file.length()];
		inputFile.read(buffer);
		inputFile.close();
		String base = Base64.encodeToString(buffer, Base64.DEFAULT);
		base = replaceBlank(base);
		return base;

	}

	/**
	 * encodeBase64File:(将文件转成base64 字符串). <br/>
	 * 
	 * @author song
	 * @param path
	 *            文件路径
	 * @return
	 * @throws Exception
	 */
	@SuppressLint("NewApi")
	public static String encodeBase64Voice(String path) throws Exception {
		File file = new File(path);
		FileInputStream inputFile = new FileInputStream(file);
		byte[] buffer = new byte[(int) file.length()];
		inputFile.read(buffer);
		inputFile.close();
		String encodeStr = Base64.encodeToString(buffer, Base64.DEFAULT);
		encodeStr = replaceBlank(encodeStr);
		return encodeStr;

	}

	public static String replaceBlank(String str) {
		String dest = "";
		if (str != null) {
			Log.e("song开始", "数据长度:" + str.length());
			// Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Pattern p = Pattern.compile("\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
			Log.e("song完毕", "数据长度:" + dest.length());
		}
		return dest;
	}



	// 加密
	public static String getBase64(String str) {

		String s = null;
		if(str!=null&&str.length()>0)
		s = Base64.encodeToString(str.getBytes(), Base64.DEFAULT);
		return s;
	}

	// 解密
	public static String getFromBase64(String s) {

		String result = null;
		if(s!=null&&s.length()>0)
		result =new String(Base64.decode(s,Base64.DEFAULT));
		return result;
	}




}
