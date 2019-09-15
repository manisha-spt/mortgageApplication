package com.bank.mortgageApp.service;

import java.util.List;

import com.bank.mortgageApp.dto.ApplyLoanDto;
import com.bank.mortgageApp.dto.LoanApplyResponseDto;
import com.bank.mortgageApp.dto.LoanDetailsResponseDto;
import com.bank.mortgageApp.dto.UserRequestDto;
import com.bank.mortgageApp.entity.LoanDetails;

public interface UserService {

	//api-1
	public List<LoanDetails> fetchLoanDetails(UserRequestDto userRequestDto);
	
	//save selected loan details
	public LoanApplyResponseDto applyForLoan(ApplyLoanDto applyLoanDto);
	
	//api-3
	public LoanDetailsResponseDto getApprovedLoanAmount(Long mobileNumber);
	
	
}
