package net.jin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.jin.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long>{//<Tabel name, id type>

}
