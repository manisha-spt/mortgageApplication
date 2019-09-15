package com.bank.mortgageApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.mortgageApp.entity.LoanDetails;

@Repository
public interface LoanRepository extends JpaRepository<LoanDetails, Integer>{
	
	//FetchLoanDetails API(api-1)
	// to populate list of loan details by eligible amount
	List<LoanDetails> findByLoanAmountLessThanEqual(Double eligibleAmount);
	
		
	
	
}
