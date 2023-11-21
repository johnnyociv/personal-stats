package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Swim;
import com.example.demo.repositories.SwimRepository;

@Service
public class SwimService {

	@Autowired
	private SwimRepository swimRepository;

	public List<Swim> getAllSwims() {
		List<Swim> swimList = new ArrayList<>();
		try {
			swimList = swimRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return swimList;
	}

	public Swim getSwimById(String swimId) {
		Swim swim = null;
		try {
			swim = swimRepository.findById(Long.valueOf(swimId)).get();
		} catch (NoSuchElementException e) {
			System.out.println("SwimId: " + swimId + " does not exist.");
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return swim;
	}

	public int addSwim(Swim swim) {
		int result = 100;
		try {
			result = swimRepository.saveSwim(swim.getStroke(), swim.getDistance(), swim.getDistanceType(), swim.getTime(), swim.getYear());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public void deleteSwim(String swimId) {
		swimRepository.deleteById(Long.valueOf(swimId));
	}

}
