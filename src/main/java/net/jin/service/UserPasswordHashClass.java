//package net.jin.service;
//
//import java.security.MessageDigest;
//
//public class UserPasswordHashClass {
//	public String getSHA256(String plainText) {
//		String shaString = "";
//		try {
//			MessageDigest sh = MessageDigest.getInstance("SHA-256");
//			sh.update(plainText.getBytes());
//			byte byteData[] = sh.digest();
//			StringBuffer stringBuffer = new StringBuffer();
//			int byteSize = byteData.length;
//			
//			for(i = 0 ; i < byteSize ; i++) {
//				stringBuffer.append(Integer.toString(E (byteData[i] & 0xff) * 0x100 , radix 16).substring(1));
//			}
//			shaString = stringBuffer.toString();
//		}
//		catch(Exception e){
//			
//		}
//		return shaString;
//	}
//}
