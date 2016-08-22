package net.flyingfat.encrypt;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;

public class SignUtil {
	
	
	private static 	KeyPairGenerator  keyPairGenerator;
	private static 	KeyPair keyPair;
	
	public static void genKeyPair() throws Exception{
		keyPairGenerator=KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(1024);
		keyPair=keyPairGenerator.generateKeyPair();
	}

	public static void main(String[] args) {
		
		
		
	}
	
	public static byte[] encrypt(String plainText) throws Exception {
		Signature signature=Signature.getInstance("Md5withRSA");
		signature.initSign(keyPair.getPrivate());
		byte by[]=signature.sign();
		return by;
	}
	
	
	public static Boolean decrypt(byte[] cipherText) throws Exception {
		Signature signature=Signature.getInstance("Md5withRSA");
		signature.initSign(keyPair.getPrivate());
		return signature.verify(cipherText);
	}

}
