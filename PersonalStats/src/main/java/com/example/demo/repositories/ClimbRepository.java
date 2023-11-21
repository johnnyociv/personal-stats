package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Climb;

@Repository
public interface ClimbRepository extends JpaRepository<Climb, Long> {

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO climbrecords (grade, type, location, year) VALUES ( ?1, ?2, ?3, ?4 )", nativeQuery = true)
	int saveClimb(String grade, String type, String location, int year);

}