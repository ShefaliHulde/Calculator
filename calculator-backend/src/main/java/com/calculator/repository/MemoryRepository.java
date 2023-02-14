package com.calculator.repository;

import org.springframework.data.repository.CrudRepository;

import com.calculator.entity.Memory;

public interface MemoryRepository extends CrudRepository<Memory, Integer>{

	void save(String memory);

}
