/*
 * This is a Jin-gamma Project
 * File name : UsersRepository.java
 * Created by : Jinhyun
 * Created on : Jan 2020
 * Contents : Users Repository similiar with mapper under mybatis
 */
package net.jin.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.jin.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{//<Tabel name, id type>
	
	//public Users findbyUserIdAndUserPw(String userId, String userPw);
		
}
