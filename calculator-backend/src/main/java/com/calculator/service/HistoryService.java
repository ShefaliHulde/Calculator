package com.calculator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.calculator.entity.History;
import com.calculator.entity.Memory;
import com.calculator.repository.HistoryRepository;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

@Component
public class HistoryService {

	@Autowired
	HistoryRepository historyRepository;

	// save
	public String addHistory(History history) {
		historyRepository.save(history);
		return history.getResult();
	}

	// delete
	public void delete() {
		historyRepository.deleteAll();
	}

	// operation
//	public String calculate(String result){
//		
//
//
//		
//		System.out.println(result.getClass());
//		String str1="";
//		String s="";
//
//		
//		for(int i=0; i<result.length();i++) {
//			System.out.println(result.charAt(i));
//			if(result.charAt(i)!='"') {
//				str1=str1+result.charAt(i);
//			}
//		}
//		System.out.println(str1);
//		double result1=0;
//		Expression expression1 = new ExpressionBuilder(str1).build();
//		try {
//          result1 = expression1.evaluate();
//		}
//		
//		catch(ArithmeticException e) {
//			return "Not defined";
//		}
//		
//        
//        int flag=0;
//        int intPart = (int) result1;
//        float f=(float) (result1 - intPart);
//        if(f==0.0000000) {
//    		flag=1;
//    	}
//        
//    	if(flag==1) {
//    		intPart=(int) Math.round(result1);
//    		s=String.valueOf(intPart);
//    	}
//    	else {
//    		s=String.valueOf(result1);
//    	}
//    	
//    	System.out.println(intPart);
//        return s;
//}

	public History calculate(History history) {

		// System.out.println(result.getClass());
		String str1 = "";
		String s;

		for (int i = 0; i < history.getExpression().length(); i++) {
			System.out.println(history.getExpression().charAt(i));
			if (history.getExpression().charAt(i) != '"') {
				str1 = str1 + history.getExpression().charAt(i);
			}
		}
		System.out.println("...........");
		System.out.println(str1);
		double result1 = 0;
		Expression expression1 = new ExpressionBuilder(str1).build();
		try {
			result1 = expression1.evaluate();
		}

		catch (ArithmeticException e) {
			history.setResult("Not Defined");
			return history;
		}

		int flag = 0;
		int intPart = (int) result1;
		float f = (float) (result1 - intPart);
		if (f == 0.0000000) {
			flag = 1;
		}

		if (flag == 1) {
			intPart = (int) Math.round(result1);
			s = String.valueOf(intPart);
			history.setResult(s);
		} else {
			s = String.valueOf(result1);
			history.setResult(String.valueOf(result1));
		}

		System.out.println(intPart);

		System.out.println(".....");
		System.out.println(s);
		System.out.println(history.getResult());

		return history;
	}

	public List<History> get() {
		return (List<History>) historyRepository.findAll();
	}

}
