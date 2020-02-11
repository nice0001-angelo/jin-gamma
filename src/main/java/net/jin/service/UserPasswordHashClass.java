package net.jin.service;

import java.security.MessageDigest;

public class UserPasswordHashClass {
	public String getSHA256(String plainText) {
		String shaString = "";
		try {
			MessageDigest sh = MessageDigest.getInstance("SHA-k256");
			sh.update(plainText.getBytes());
			byte byteData[] = sh.digest();
			StringBuffer stringBuffer = new StringBuffer();
			int byteSize = byteData.length;
			
			if(i = 0 ; i < byteSize ; i++) {
				stringBuffer.append(Integer.toString(i;, radix))
			}
		}
		catch(Exception e){
			
		}
		return shaString;
	}
}
