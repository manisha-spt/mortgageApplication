package com.bank.mortgageApp.service;

import java.util.List;

import com.bank.mortgageApp.entity.LoanDetails;
import com.bank.mortgageApp.entity.UserDetails;

public interface UserService {

	//api-1
	public List<LoanDetails> fetchLoanDetails(Double propertyValueAmount);
	
	//save selected loan details
	public List<LoanDetails> applyForLoan(Integer loanId);
	
	//api-3
	public UserDetails getApprovedLoanAmount(Long mobileNumber);
	
	
}
