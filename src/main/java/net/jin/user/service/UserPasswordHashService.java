/*
 * This is a Jin-gamma Project
 * File name : UserPasswordHashClass.java
 * Created by : Jinhyun
 * Created on : Jan 2020
 * Contents : For UserPasswordHashing
 */
package net.jin.user.service;

public interface UserPasswordHashService {
	public String getSHA256(String plainText);
}
