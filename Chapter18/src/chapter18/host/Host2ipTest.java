package chapter18.host;

import java.net.InetAddress;

public class Host2ipTest {

	public static void main(String[] args) throws Exception {
		String hostName = "www.naver.com";
		
		InetAddress address = InetAddress.getByName(hostName);
		
		System.out.println(hostName + " 주소는 : " + address.getHostAddress());
	}

}
