package net.flyingfat.Ssl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ServerSocketFactory;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class ServerSsl {
	
	public static void main(String[] args) throws Exception {
		// notOk();
		sslSocketServer();
	}

	// 抛出异常
	// javax.net.ssl.SSLException: No available certificate or key corresponds
	// to the SSL cipher suites which are enabled.
	public static void notOk() throws IOException {
		SSLServerSocketFactory factory = (SSLServerSocketFactory) SSLServerSocketFactory
				.getDefault();
		SSLServerSocket server = (SSLServerSocket) factory
				.createServerSocket(10000);
		System.out.println("ok");
		server.accept();
	}

	// 启动一个ssl server socket
	// 配置了证书, 所以不会抛出异常
	public static void sslSocketServer() throws Exception {

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
		ks.load(ServerSsl.class.getClassLoader().getResourceAsStream("ks/kserver.keystore"), "123456".toCharArray());
		tks.load(ServerSsl.class.getClassLoader().getResourceAsStream("ks/tserver.keystore"), "123456".toCharArray());
		
		kmf.init(ks, "123456".toCharArray());
		tmf.init(tks);

		SSLContext context = SSLContext.getInstance("SSL");
		context.init(kmf.getKeyManagers(),tmf.getTrustManagers(),new SecureRandom());
		
		// 监听和接收客户端连接
		SSLServerSocketFactory factory = context.getServerSocketFactory();
		SSLServerSocket server = (SSLServerSocket) factory
				.createServerSocket(10002);
		//server.setNeedClientAuth(true);
		
		System.out.println("ok");
		Socket client = server.accept();
		System.out.println(client.getRemoteSocketAddress());

		// 向客户端发送接收到的字节序列
		OutputStream output = client.getOutputStream();

		// 当一个普通 socket 连接上来, 这里会抛出异常
		// Exception in thread "main" javax.net.ssl.SSLException: Unrecognized
		// SSL message, plaintext connection?
		InputStream input = client.getInputStream();
		byte[] buf = new byte[1024];
		int len = input.read(buf);
		System.out.println("received: " + new String(buf, 0, len));
		output.write(buf, 0, len);
		output.flush();
		output.close();
		input.close();

		// 关闭socket连接
		client.close();
		server.close();
	}

	// 启动一个普通的server socket
	public static void socketServer() throws IOException {
		ServerSocket server = new ServerSocket(10002);
		System.out.println("ok");

		Socket client = server.accept();
		System.out.println(client.getRemoteSocketAddress());

		// 向客户端发送接收到的字节序列
		OutputStream output = client.getOutputStream();
		InputStream input = client.getInputStream();
		byte[] buf = new byte[1024];
		int len = input.read(buf);
		System.out.println("received: " + new String(buf, 0, len));
		output.write(buf, 0, len);
		output.flush();
		output.close();

		// 关闭socket连接
		client.close();
		server.close();
	}

	public static class MyX509TrustManager implements X509TrustManager {

		@Override
		public void checkClientTrusted(X509Certificate[] chain, String authType)
				throws CertificateException {
			System.out.println("click trust");
		}

		@Override
		public void checkServerTrusted(X509Certificate[] chain, String authType)
				throws CertificateException {
			System.out.println("server trust");
		}

		@Override
		public X509Certificate[] getAcceptedIssuers() {
			return null;
		}

	}
	
}
