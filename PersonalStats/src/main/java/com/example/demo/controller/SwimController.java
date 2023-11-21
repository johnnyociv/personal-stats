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

import com.example.demo.model.Swim;
import com.example.demo.service.SwimService;

@RestController
@RequestMapping("/swim")
public class SwimController {

	@Autowired
	private SwimService swimService;

	@GetMapping
	public @ResponseBody List<Swim> getAllSwims() {
		List<Swim> resultList = swimService.getAllSwims();
		
		System.out.println(resultList.size() + " entries found");
		
		return resultList;
	} 

	@GetMapping("/id")
	public @ResponseBody Swim getSwimById(@PathVariable(value = "id") String swimId) {
		return swimService.getSwimById(swimId);
	}

	@PostMapping
	public int addSwim(@RequestBody Swim swim) {
		System.out.println("Swim object received is: " + swim);

		return swimService.addSwim(swim);
	}

	@DeleteMapping
	public void deleteSwim(@PathVariable(value = "swimId") String swimId) {
		swimService.deleteSwim(swimId);
	}
}