package net.flyingfat.Ssl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.Arrays;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

public class ClientSsl {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		 sslSocket2();
		//socket();
	}

	// 通过socket连接服务器
	public static void socket() throws UnknownHostException, IOException {
		Socket s = new Socket("localhost", 10002);
		System.out.println(s);
		System.out.println("ok");

		OutputStream output = s.getOutputStream();
		InputStream input = s.getInputStream();

		output.write("alert".getBytes());
		System.out.println("sent: alert");
		output.flush();

		byte[] buf = new byte[1024];
		int len = input.read(buf);
		System.out.println(Arrays.toString(new String(buf, 0, len).getBytes()));

		System.out.println("received:" + new String(buf, 0, len));
	}

	// 不使用证书, 通过ssl socket连接服务器
	// 抛出异常, 提示找不到证书
	public static void sslSocket() throws UnknownHostException, IOException {
		SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory
				.getDefault();
		SSLSocket s = (SSLSocket) factory.createSocket("localhost", 10002);
		System.out.println("ok");

		OutputStream output = s.getOutputStream();
		InputStream input = s.getInputStream();

		output.write("alert".getBytes());
		System.out.println("sent: alert");
		output.flush();

		byte[] buf = new byte[1024];
		int len = input.read(buf);

		System.out.println("received:" + new String(buf, 0, len));
	}

	// 这种情况是使用空证书??
	public static void sslSocket2() throws Exception {
		
		/*String keyName = "cmkey";
		char[] keyPwd = "123456".toCharArray();
		KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
		InputStream in = null;
		keyStore.load(in = ServerSsl.class.getClassLoader().getResourceAsStream(keyName), keyPwd);
		in.close();
		KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
		kmf.init(keyStore, keyPwd);*/
		
		KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
		TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
		KeyStore ks = KeyStore.getInstance("JKS");
		KeyStore tks = KeyStore.getInstance("JKS");
		ks.load(ServerSsl.class.getClassLoader().getResourceAsStream("ks/kclient.keystore"), "123456".toCharArray());
		tks.load(ServerSsl.class.getClassLoader().getResourceAsStream("ks/tclient.keystore"), "123456".toCharArray());
		
		kmf.init(ks, "123456".toCharArray());
		tmf.init(tks);
		
		SSLContext context = SSLContext.getInstance("SSL");
		context.init(kmf.getKeyManagers(),tmf.getTrustManagers(),new SecureRandom());
		SSLSocketFactory factory = context.getSocketFactory();
		SSLSocket s = (SSLSocket) factory.createSocket("localhost", 10002);
		System.out.println("ok");

		OutputStream output = s.getOutputStream();
		InputStream input = s.getInputStream();

		output.write("alert".getBytes());
		System.out.println("sent: alert");
		output.flush();

		byte[] buf = new byte[1024];
		int len = input.read(buf);
		System.out.println("received:" + new String(buf, 0, len));
	}
}
