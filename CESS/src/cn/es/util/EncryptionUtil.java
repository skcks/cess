package cn.es.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptionUtil {

	public static String Md5Bit32(String plainText) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return plainText;
		}
		md.update(plainText.getBytes());
		byte b[] = md.digest();
		int i;
		StringBuffer buf = new StringBuffer("");
		for (int offset = 0; offset < b.length; offset++) {
			i = b[offset];
			if (i < 0)
				i += 256;
			if (i < 16)
				buf.append("0");
			buf.append(Integer.toHexString(i));
		}
		return buf.toString();
	}

	public static String Md5Bit16(String plainText) {
		return EncryptionUtil.Md5Bit32(plainText).substring(8, 24);
	}

	public static String Md5Enhand(String plainText, int mixTimes, boolean isShort) {
		String retValue = plainText;
		for (int i = 0; i < mixTimes; i++) {
			retValue = (isShort==true?Md5Bit16(retValue):Md5Bit32(retValue));
		}
		return retValue;
	}
	
	static public void main(String[] args) {
		System.out.println("admin 32位加密:"+Md5Bit32("admin"));
		System.out.println("admin 32位2次加密:"+Md5Enhand("admin", 2, false));
		System.out.println("admin 16位加密:"+Md5Bit16("admin"));
		System.out.println("admin 16位2次加密:"+Md5Enhand("admin", 2, true));
	}
}
