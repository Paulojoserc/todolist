package br.com.pjtec.todolist.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserModel, UUID> {
	
	UserModel findByUserName(String userName);

}
