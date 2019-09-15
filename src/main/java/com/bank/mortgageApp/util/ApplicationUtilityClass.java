package com.bank.mortgageApp.util;

import org.springframework.stereotype.Component;

@Component
public class ApplicationUtilityClass {
	
	public double calculateEligibleAmount(double amount) {
		double eligibleAmount=(amount * 80)/100;
		return eligibleAmount;
	}


}
