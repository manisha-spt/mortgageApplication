package com.bank.mortgageApp.controller;

import java.util.List;

//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bank.mortgageApp.entity.LoanDetails;
import com.bank.mortgageApp.service.UserService;

@RestController
public class UserController {

	UserService userService;
	
	@GetMapping("/{propertyValueAmount}")
	//public ResponseEntity<List<LoanDetails>> getLoanDetails(@PathVariable double propertyValueAmount){
	public List<LoanDetails> getLoanDetails(@PathVariable Double propertyValueAmount){
	
	List<LoanDetails> loanDetails = userService.fetchLoanDetails(propertyValueAmount);
	//	return new ResponseEntity<List<LoanDetails>>(loanDetails, HttpStatus.CREATED);
		return loanDetails;
	}
}
