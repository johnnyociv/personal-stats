package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Swim;

@Repository
public interface SwimRepository extends JpaRepository<Swim, Long> {

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO swimrecords (stroke, distance, distance_type, time, year ) VALUES ( ?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
	int saveSwim(String stroke, int distance, char distance_type, double time, int year);
	
}