package com.bank.mortgageApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.mortgageApp.dto.ApplyLoanDto;
import com.bank.mortgageApp.dto.LoanApplyResponseDto;
import com.bank.mortgageApp.dto.LoanDetailsResponseDto;
import com.bank.mortgageApp.dto.UserRequestDto;
import com.bank.mortgageApp.entity.LoanDetails;
import com.bank.mortgageApp.service.UserService;

@RestController
@RequestMapping("/mortgageApplication")
public class UserController {

	
	@Autowired
	UserService userService;
	
	@PostMapping("/loan")
	public ResponseEntity<List<LoanDetails>> getLoanDetails(@RequestBody UserRequestDto userRequestDto){
	List<LoanDetails> loanDetails = userService.fetchLoanDetails(userRequestDto);
		return new ResponseEntity<>(loanDetails, HttpStatus.OK);
	}
	
	@PutMapping("/Apply")
	public ResponseEntity<LoanApplyResponseDto> applyLoan(@RequestBody ApplyLoanDto applyLoanDto)
	{
		return new ResponseEntity<>(userService.applyForLoan(applyLoanDto), HttpStatus.OK);
	}
	
	@GetMapping("/loanDeatail/{mobileNumber}")
	public ResponseEntity<LoanDetailsResponseDto> getDetails(@PathVariable Long mobileNumber)
	{
		
		return new ResponseEntity<>(userService.getApprovedLoanAmount(mobileNumber),HttpStatus.OK);
	}
}

