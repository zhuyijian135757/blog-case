package net.flyingfat.encrypt;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;

public class RSAUtil {

	private static 	KeyPairGenerator  keyPairGenerator;
	private static 	KeyPair keyPair;
	private static  String plainText="9876jklo8881sdfadfasfasfl23451adfadsfasdfasdfasdfasdfasdfggfdhdfgdfdfgdsfgsdfgsdfgsdfgsdfgdfg6";
	
	
	public static void main(String[] args)  throws Exception {
		Long start=System.currentTimeMillis();
		genKeyPair();
		byte enby[]=encrypt(plainText);
		Long end=System.currentTimeMillis();
		System.out.println(end-start);
		
		/*Long end3=System.currentTimeMillis();
		System.out.println(decrypt(enby));
		Long end4=System.currentTimeMillis();
		System.out.println(end4-end3);*/
	}
	
	public static void genKeyPair() throws Exception{
		keyPairGenerator=KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(1024);
		keyPair=keyPairGenerator.generateKeyPair();
	}
	
	public static byte[] encrypt(String plainText) throws Exception {
		PublicKey publicKey=keyPair.getPublic();
		Cipher cipher=Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		byte by[]=cipher.doFinal(plainText.getBytes("utf-8"));
		return by;
	} 
	
	public static String decrypt(byte[] cipherText) throws Exception {
		PrivateKey privateKey=keyPair.getPrivate();
		Cipher cipher=Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		byte by[]=cipher.doFinal(cipherText);
		return new String(by,"utf-8");
	}

}
