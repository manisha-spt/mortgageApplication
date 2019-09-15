package com.bank.mortgageApp.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.mortgageApp.dto.ApplyLoanDto;
import com.bank.mortgageApp.dto.LoanApplyResponseDto;
import com.bank.mortgageApp.dto.LoanDetailsResponseDto;
import com.bank.mortgageApp.dto.UserRequestDto;
import com.bank.mortgageApp.entity.LoanDetails;
import com.bank.mortgageApp.entity.UserDetails;
import com.bank.mortgageApp.repository.LoanRepository;
import com.bank.mortgageApp.repository.UserRepository;
import com.bank.mortgageApp.util.ApplicationUtilityClass;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	LoanRepository loanRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	ApplicationUtilityClass applicationUtilityClass;

	@Override
	public List<LoanDetails> fetchLoanDetails(UserRequestDto userRequestDto) {
		UserDetails userDetail = new UserDetails();
		double eligibleAmount = applicationUtilityClass.calculateEligibleAmount(userRequestDto.getPropertyValue());
		List<LoanDetails> loanDetails = loanRepository.findByLoanAmountLessThanEqual(eligibleAmount);

		// Save data in UserDetails table

		userDetail.setFirstName(userRequestDto.getFirstName());
		userDetail.setLastName(userRequestDto.getLastName());
		userDetail.setDOB(userRequestDto.getDob());
		userDetail.setEmail(userRequestDto.getEmail());
		userDetail.setMobileNumber(userRequestDto.getMobileNumber());
		userDetail.setPropertyName(userRequestDto.getPropertyName());
		userDetail.setPropertyType(userRequestDto.getPropertyType());
		userDetail.setPropertyValue(userRequestDto.getPropertyValue());
		userRepository.save(userDetail);
		return loanDetails;
	}

	@Override
	public LoanApplyResponseDto applyForLoan(ApplyLoanDto applyLoanDto) {

		LoanApplyResponseDto loanApplyResponseDto = new LoanApplyResponseDto();
		UserDetails Userepo = userRepository.findById(applyLoanDto.getUserId()).get();

		LoanDetails loanDetails = loanRepository.findById(applyLoanDto.getLoanId()).get();

		Userepo.setLoanDetails(loanDetails);

		userRepository.save(Userepo);
		loanApplyResponseDto.setMessage("success");
		loanApplyResponseDto.setStatusCode(200);

		return loanApplyResponseDto;
	}

	@Override
	public LoanDetailsResponseDto getApprovedLoanAmount(Long mobileNumber) {
		LoanDetailsResponseDto loanDetailsResponseDto = new LoanDetailsResponseDto();
		UserDetails userEntity = userRepository.findByMobileNumber(mobileNumber);
		LoanDetails loanDetails = userEntity.getLoanDetails();
		BeanUtils.copyProperties(loanDetails, loanDetailsResponseDto);
		return loanDetailsResponseDto;

	}

}
