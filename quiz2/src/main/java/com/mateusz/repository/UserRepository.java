package com.mateusz.repository;


import com.mateusz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, String> {

    @Query(value="select e from User e")
    List<User> findAllUsers();
}
