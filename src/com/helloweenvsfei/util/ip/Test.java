package com.helloweenvsfei.util.ip;

import java.util.List;

public class Test {
	public static void main(String[] args) {
		
		args = new String[]{"ip", "127.0.0.1"};
		
		IPSeeker seeker = IPSeeker.getInstance();

		if(args.length==2){
			if("ip".equals(args[0])){
				System.out.println(args[0]+"�����ڵ�ַ��:"+seeker.getAddress(args[1]));
                            System.out.println(args[0]+"�����ڵ�ַ������:"+seeker.getCountry(args[1]));
			}else if("address".equals(args[0])){
				List a = seeker.getIPEntries(args[1]);
System.out.println(args[0]+":");
				for(int i=0;i<a.size();i++){
					System.out.println(a.get(i).toString());
				}
			}else{
				System.out.println("usage:java Test ip/address yourIpString/yourAddressString");
			}
		}else{
			System.out.println("usage:java Test ip/address yourIpString/yourAddressString");
	 
              }
 }
}
