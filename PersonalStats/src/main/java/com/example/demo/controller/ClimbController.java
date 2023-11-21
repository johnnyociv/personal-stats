package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Climb;
import com.example.demo.service.ClimbService;

@RestController
@RequestMapping("/climb")
public class ClimbController {

	@Autowired
	private ClimbService climbService;

	@GetMapping
	public @ResponseBody List<Climb> getAllClimbs() {
		List<Climb> resultList = climbService.getAllClimbs();
		
		System.out.println(resultList.size() + " entries found");
		
		return resultList;
	}

	@GetMapping("/id")
	public @ResponseBody Climb getClimbById(@PathVariable(value = "id") String climbId) {
		return climbService.getClimbById(climbId);
	}

	@PostMapping
	public @ResponseBody int addClimb(@RequestBody Climb climb) {
		System.out.println("Post request with Obj: " + climb);
		return climbService.addClimb(climb);
	}

	@DeleteMapping
	public void deleteClimb(@PathVariable(value = "climbId") String climbId) {
		climbService.deleteClimb(climbId);
	}

}
