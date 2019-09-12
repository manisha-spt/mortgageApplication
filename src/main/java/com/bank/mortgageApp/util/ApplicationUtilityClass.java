package com.bank.mortgageApp.util;

public class ApplicationUtilityClass {
	
	public double calculateEligibleAmount(double amount) {
		double eligibleAmount=(amount * 80)/100;
		return eligibleAmount;
	}


}
