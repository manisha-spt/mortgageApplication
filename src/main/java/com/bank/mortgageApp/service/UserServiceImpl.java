package com.bank.mortgageApp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.mortgageApp.entity.LoanDetails;
import com.bank.mortgageApp.entity.UserDetails;
import com.bank.mortgageApp.repository.LoanRepository;
import com.bank.mortgageApp.repository.UserRepository;
import com.bank.mortgageApp.util.ApplicationUtilityClass;

@Service
public class UserServiceImpl implements UserService {

	LoanRepository loanRepository;
	UserRepository userRepository;
	ApplicationUtilityClass applicationUtilityClass; 
	
	
	@Override
	public List<LoanDetails> fetchLoanDetails(Double propertyValueAmount) {
		double eligibleAmount = applicationUtilityClass.calculateEligibleAmount(propertyValueAmount);
		List<LoanDetails> loanDetails = loanRepository.findByLoanAmount(eligibleAmount);
		return loanDetails;
	}

	@Override
	public List<LoanDetails> applyForLoan(Integer loanId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public UserDetails getApprovedLoanAmount(Long mobileNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
