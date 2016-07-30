package net.flyinfat.encrypt;

import java.security.Key;
import java.security.MessageDigest;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESUtil {

	private static String key = "liuliangchongzhi"; // 对称秘钥
	private static String iv = "aabbccddeeffgghh"; // 初始化向量
	private static final String HEX_CHARS = "0123456789abcdef";
	private static Key keySpec = new SecretKeySpec(key.getBytes(), "AES");
	private static IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());

	public static byte[] encrypt(String plainText) throws Exception {
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
		byte[] b = cipher.doFinal(plainText.getBytes("utf-8"));
		return b;
	}

	public static String decrypt(byte[] cipherText) throws Exception {
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
		byte[] b = cipher.doFinal(cipherText);
		return new String(b, "utf-8");
	}

	public static String getShaMsg(byte[] b) throws Exception {
		MessageDigest digest = MessageDigest.getInstance("SHA");
		byte by[] = digest.digest(b);
		return toHexString(by);
	}

	public static String toHexString(byte[] b) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			sb.append(HEX_CHARS.charAt(b[i] >>> 4 & 0xF));
			sb.append(HEX_CHARS.charAt(b[i] & 0xF));
		}
		return sb.toString();
	}

	public static byte[] toByteArray(String s) {
		byte[] buf = new byte[s.length() / 2];
		int j = 0;
		for (int i = 0; i < buf.length; i++) {
			buf[i] = ((byte) (Character.digit(s.charAt(j++), 16) << 4 | Character
					.digit(s.charAt(j++), 16)));
		}
		return buf;
	}

	public static void main(String[] args) throws Exception {
		String plainText = "{\"cpId\":\"1111\",channelOrderId:\"20160728100\",\"phone\":\"13575712492\","
				+ "goodsId:\"100\",\"createTime\":\"20160728094900\",\"notifyUrl\":\"http://host:port/\"}";
		byte[] b = encrypt(plainText);
		System.out.println(decrypt(b));
		System.out.println(getShaMsg(b));
	}

}
