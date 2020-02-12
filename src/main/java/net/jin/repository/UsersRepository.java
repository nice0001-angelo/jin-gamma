/*
 * This is a Jin-gamma Project
 * File name : UsersRepository.java
 * Created by : Jinhyun
 * Created on : Jan 2020
 * Contents : Users Repository similiar with mapper under mybatis
 */
package net.jin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.jin.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long>{//<Tabel name, id type>
	public Users findByUser_idAndUser_pw(String userId, String userPw);
}
