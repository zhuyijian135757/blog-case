package net.flyingfat.encrypt;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DESUtil {
	private static final Logger logger = LoggerFactory.getLogger(DESUtil.class);
	public static final String PASSWORD_CRYPT_KEY = "secretkey"; //秘钥大于8位
	private static final String algorithm = "DES/ECB/NoPadding";

	public static byte[] encrypt(byte[] src, byte[] key) throws Exception {
		src = padding(src, (byte) 0);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		DESKeySpec dks = new DESKeySpec(key);
		SecretKey securekey = keyFactory.generateSecret(dks);
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.ENCRYPT_MODE, securekey);
		return cipher.doFinal(src);
	}

	public static byte[] decrypt(byte[] src, byte[] key) throws Exception {
		DESKeySpec dks = new DESKeySpec(key);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey securekey = keyFactory.generateSecret(dks);
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.DECRYPT_MODE, securekey);
		return cipher.doFinal(src);
	}

	public static final byte[] decryptString(String data, byte[] key) {
		try {
			return decrypt(StringUtil.hex2byte(data.getBytes()), key);
		} catch (Exception e) {
			logger.error("", e);
		}
		return null;
	}

	private static byte[] padding(byte[] sourceBytes, byte b) {
		int paddingSize = 8 - sourceBytes.length % 8;
		byte[] paddingBytes = new byte[paddingSize];
		for (int i = 0; i < paddingBytes.length; i++) {
			paddingBytes[i] = b;
		}
		sourceBytes = ArrayUtils.addAll(sourceBytes, paddingBytes);
		return sourceBytes;
	}

	public static void main(String[] argv) throws Exception {
		String source = "its a secretkey!";
		byte[] encrypted = encrypt(source.getBytes(), "liuliangchongzhi".getBytes());
		byte[] decrypted = decrypt(encrypted, "liuliangchongzhi".getBytes());
		
		System.out.println("source:" + source);
		System.out.println("encrypted:" + StringUtil.byte2Hex(encrypted));
		System.out.println("decrypted:" + new String(decrypted));
	}
}
