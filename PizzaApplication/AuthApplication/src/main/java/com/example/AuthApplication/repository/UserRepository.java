package com.example.AuthApplication.repository;

import com.example.AuthApplication.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByEmailIdAndPassword(String emailId , String password);
}
