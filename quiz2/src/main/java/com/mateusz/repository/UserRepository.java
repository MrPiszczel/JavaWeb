package com.mateusz.repository;

import com.mateusz.model.Question;
import com.mateusz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
   User findByLogin(String login);

  // User findOne(String name);

   @Query(value="Select e from User e")
   List<User> findAllUserName();

   @Query(value="Select UPPER(e.login) from User e")
   User findAllUserLogin();

   @Query(value="select Upper(e.id) from User e")
   List<Long> findAllid();

}
