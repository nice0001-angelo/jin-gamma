package net.jin.service;

import java.security.MessageDigest;

public class UserPasswordHashClass {
	public String getSHA256(String plainText) {
		String shaString = "";
		try {
			MessageDigest sh = MessageDigest.getInstance("SHA-k256");
		}
		catch(Exception e){
			
		}
		return shaString;
	}
}
