package org.mybatis.supergen.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Decoder;

/**
 * 
 * @ClassName: StringUtil
 * @Description: 字符串操作帮组类
 * @author hncdyj123@163.com
 * @date 2015年11月21日 下午12:37:10
 *
 */
public class StringUtil {

	/**
	 * 判断一个字符串Str是否为空 return true if it is supplied with an empty, zero length, or whitespace-only string. documented
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isEmptyString(String str) {
		return (str == null) || (str.trim().length() == 0);
	}

	public static boolean isEmpty(String str) {
		return (str == null) || (str.trim().length() == 0);
	}

	/**
	 * 将String数组转换成Integer数组
	 * 
	 * @param s
	 * @return Integer[]
	 */
	public static Integer[] convertToIntegerArray(String[] s) {
		Integer[] num = new Integer[s.length];
		for (int i = 0; i < s.length; i++) {
			num[i] = new Integer(s[i]);
		}
		return num;
	}

	/**
	 * 将字符串数组转换成字符串
	 * 
	 * @param str
	 * @return String
	 */
	public static String arrayToString(String[] str) {
		if (str == null)
			return "";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < str.length; i++) {
			sb.append(str[i]);
			sb.append(", ");
		}
		return sb.toString();
	}

	/**
	 * 判断字符串是否存在于指定的字符串数组中
	 * 
	 * @param str
	 * @param array
	 * @return boolean
	 */
	public static boolean isExist(String str, String[] array) {
		boolean result = false;
		if (array == null)
			return result;

		for (int i = 0; i < array.length; i++) {
			if (str.equals(array[i]))
				result = true;
		}
		return result;
	}

	/**
	 * 右对齐填充字符
	 * 
	 * @param data
	 * @param length
	 * @param fill
	 * @return String
	 */
	public static String rightAlign(String data, int length, String fill) {
		for (int i = data.length(); i < length; i++) {
			data = fill + data;
		}
		return data;
	}

	/**
	 * 左对齐填充字符
	 * 
	 * @param data
	 * @param length
	 * @param fill
	 * @return
	 */
	public static String leftAlign(String data, int length, String fill) {
		for (int i = data.length(); i < length; i++) {
			data = data + fill;
		}
		return data;
	}

	/**
	 * base64编码
	 * 
	 * @param s
	 * @return String
	 */
	public static String getBASE64(String s) {
		if (s == null) {
			return null;
		}
		try {
			return (new sun.misc.BASE64Encoder()).encode(s.getBytes("UTF-8"));
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * 解码方法, 把一个BASE64编码的字符串解码为编码前的字符串
	 * 
	 * @param in
	 *            需要解码的BASE64编码的字符串
	 * 
	 * @return String
	 */
	public static String decode(String in) {
		String s = null;
		try {
			byte[] arrB = new BASE64Decoder().decodeBuffer(in);
			s = new String(arrB, "UTF-8");
		} catch (Exception ex) {
			s = null;
		}
		return s;
	}

	/**
	 * MD5转换
	 * 
	 * @param plainText
	 * 
	 * @return MD5字符串
	 */
	public static String toMD5(String plainText) throws NoSuchAlgorithmException {

		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		messageDigest.update(plainText.getBytes());
		byte by[] = messageDigest.digest();

		StringBuffer buf = new StringBuffer();
		int val;
		for (int i = 0; i < by.length; i++) {
			val = by[i];
			if (val < 0) {
				val += 256;
			} else if (val < 16) {
				buf.append("0");
			}
			buf.append(Integer.toHexString(val));
		}
		return buf.toString();
	}

	public static boolean equalsString(String sourceStr, String targetStr) {
		return sourceStr.equals(targetStr);
	}

	/**
	 * 首字母大写
	 * 
	 * @param name
	 * @return
	 */
	public static String captureName(String name) {
		if (!isEmptyString(name)) {
			char[] cs = name.toCharArray();
			if (Character.isUpperCase(cs[0])) {
				return name;
			}
			cs[0] -= 32;
			return String.valueOf(cs);
		}
		return null;
	}

}
