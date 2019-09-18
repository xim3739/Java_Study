package chapter18.dogPic_test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;

public class DogPictureTest {

	public static void main(String[] args) throws Exception {
		
		URL url = new URL("https://cdn.imweb.me/upload/S201807025b39d1981b0b0/5cad8fb10687d.jpg");
		
		URLConnection urlConnection = url.openConnection();
		
		BufferedInputStream bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());
		
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("dogPic2.jpg"));
		
		//byte[] b = new byte[1024];
		int data = 0;
		while((data = bufferedInputStream.read()) != -1) {
			bufferedOutputStream.write(data);
		}
		
		bufferedOutputStream.flush();
		
		if(bufferedInputStream != null) {
			bufferedInputStream.close();
		}
		
		if(bufferedOutputStream != null) {
			bufferedOutputStream.close();
		}
		
	}
	
}
