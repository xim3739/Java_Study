package chapter18.URL_Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class URLConnectionTest {

	public static void main(String[] args) throws Exception {
		
		URL url = new  URL("http://www.nate.com:80/index.html");
		InputStream inputStream = url.openStream();
		
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		
		String data = null;
		while((data = bufferedReader.readLine()) != null) {
			System.out.println(data);
		}
		
		if(bufferedReader != null) {
			bufferedReader.close();
		}
		
	}

}
