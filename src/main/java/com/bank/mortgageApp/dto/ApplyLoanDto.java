package com.bank.mortgageApp.dto;

public class ApplyLoanDto {
	private Integer loanId;
	public Integer getLoanId() {
		return loanId;
	}
	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	private Integer userId;

}
