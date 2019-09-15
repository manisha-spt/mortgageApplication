package com.bank.mortgageApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.mortgageApp.entity.UserDetails;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Integer> {

	UserDetails findByMobileNumber(Long mobileNumber);
}
