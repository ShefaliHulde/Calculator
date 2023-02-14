package com.calculator.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.calculator.entity.Memory;
import com.calculator.repository.MemoryRepository;
@Component
public class MemoryService {

	@Autowired
	MemoryRepository memoryRepository;
	
	public void deleteMemory() {
		memoryRepository.deleteAll();
	}
	
	public void save(Memory memory) {
		memoryRepository.save(memory);
	}
}
