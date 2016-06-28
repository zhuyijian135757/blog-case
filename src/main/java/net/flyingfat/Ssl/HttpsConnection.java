package net.flyingfat.Ssl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public class HttpsConnection {

	public static void main(String[] args) throws Exception {
		SSLContext sslContext=SSLContext.getInstance("TLS");
		sslContext.init(null, null, new SecureRandom());
		SSLSocketFactory sslSocketFactory=sslContext.getSocketFactory();
		URL url=new URL("https://www.baidu.com/");
		HttpsURLConnection conn=(HttpsURLConnection) url.openConnection();
		conn.setSSLSocketFactory(sslSocketFactory);
		conn.connect();
		InputStream input=conn.getInputStream();
		BufferedReader reader=new BufferedReader(new InputStreamReader(input));
		String line="";
		while((line=reader.readLine())!=null){
			System.out.println(line);
		}
		reader.close();
		input.close();
		conn.disconnect();
	}

}
