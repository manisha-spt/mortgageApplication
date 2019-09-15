package com.bank.mortgageApp.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.bank.mortgageApp.dto.UserRequestDto;
import com.bank.mortgageApp.entity.LoanDetails;
import com.bank.mortgageApp.repository.LoanRepository;
import com.bank.mortgageApp.repository.UserRepository;
import com.bank.mortgageApp.util.ApplicationUtilityClass;


@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
	
	@Mock
	LoanRepository loanRepository;
	@Mock
	UserRepository userRepository;
	@Mock
	ApplicationUtilityClass applicationUtilityClass;
	@InjectMocks
	UserServiceImpl userServiceImpl;	

	@Test
	public void testFetchLoanDetails() {
		
		List<LoanDetails> listLoan=new ArrayList<>();
		LoanDetails loanDetails =new LoanDetails();
		loanDetails.setEmi("3");
		loanDetails.setLoanAmount(900000.0);
		loanDetails.setLoanId(1);
		loanDetails.setRateOfInterest(0.6);
		loanDetails.setTenure(2);
		listLoan.add(loanDetails);
		Mockito.when(loanRepository.findByLoanAmountLessThanEqual(Mockito.anyDouble())).thenReturn(listLoan);
		UserRequestDto userRequestDto=new UserRequestDto();
		userRequestDto.setDob("03/02/1994");
		userRequestDto.setEmail("");
		userRequestDto.setFirstName("");
		userRequestDto.setGender("");
		userRequestDto.setLastName("");
		userRequestDto.setMobileNumber(9888766L);
		userRequestDto.setPropertyName("");
		userRequestDto.setPropertyType("");
		
		List<LoanDetails> actual=userServiceImpl.fetchLoanDetails(userRequestDto);
		assertEquals(1, actual.size());
	}

}
