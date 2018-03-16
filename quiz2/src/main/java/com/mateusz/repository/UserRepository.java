package com.mateusz.repository;

import com.mateusz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
   User findByLogin(String login);

   @Query(value="Select e from User e")
   List<User> findAllUserName();

   @Query(value="Select UPPER(e.login) from User e")
   User findOneUserLogin();


}
