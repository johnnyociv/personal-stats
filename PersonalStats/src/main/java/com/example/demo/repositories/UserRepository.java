package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.User;

@Transactional(readOnly = true)
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
