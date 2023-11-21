package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Climb;
import com.example.demo.repositories.ClimbRepository;

@Service
public class ClimbService {

	@Autowired
	private ClimbRepository climbRepository;

	public List<Climb> getAllClimbs() {
		List<Climb> climbList = new ArrayList<>();
		try {
			climbList = climbRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return climbList;
	}

	public Climb getClimbById(String climbId) {
		Climb climb = null;
		try {
			climb = climbRepository.findById(Long.valueOf(climbId)).get();
		} catch (NoSuchElementException e) {
			System.out.println("ClimbId: " + climbId + " does not exist.");
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return climb;
	}

	public int addClimb(Climb climb) {
		int result = 100;
		try {
			result = climbRepository.saveClimb(climb.getGrade(), climb.getType(), climb.getLocation(), climb.getYear());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public void deleteClimb(String climbId) {
		climbRepository.deleteById(Long.valueOf(climbId));
	}

}
