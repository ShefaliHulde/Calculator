package com.calculator.repository;

import org.springframework.data.repository.CrudRepository;

import com.calculator.entity.History;

public interface HistoryRepository extends CrudRepository<History, Integer>{

	

}
