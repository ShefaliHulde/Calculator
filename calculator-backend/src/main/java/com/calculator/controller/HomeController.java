package com.calculator.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.calculator.entity.History;
import com.calculator.entity.Memory;
import com.calculator.service.HistoryService;
import com.calculator.service.MemoryService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class HomeController {
	
	@Autowired
	HistoryService historyService;
	@Autowired
	MemoryService  memoryService;
	
	@PostMapping("/calculate")
	public String cal(@RequestBody History history) {
		System.out.println(history);
		
		historyService.calculate(history);
		return historyService.addHistory(history);
		
		
	}
	
//	    @PostMapping("/calculate")
//	    public String cal(@RequestBody String result) {
//	    	System.out.println(result);
//	    	return historyService.calculate(result);
//		}
//	    
	
	@DeleteMapping("/delete")
	public void deleteMemeory() {
		memoryService.deleteMemory();
	}
	
	@PostMapping("/save")
	public void addMemory(@RequestBody Memory memory) {
		System.out.println(memory);
		memoryService.save(memory);
	}
	
	@GetMapping("/history")
	public List<History> getMemory() {
		return historyService.get();
	}
	
	

}
