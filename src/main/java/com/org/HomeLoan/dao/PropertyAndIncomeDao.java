package com.org.HomeLoan.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.HomeLoan.dto.PropertyAndIncome;
import com.org.HomeLoan.repo.PropertyAndIncomeRepo;

@Repository
public class PropertyAndIncomeDao {
	
	@Autowired
	PropertyAndIncomeRepo propertyAndIncomeRepo;

	public PropertyAndIncome findCustomerIncomeById(int id) {
		Optional<PropertyAndIncome> income = propertyAndIncomeRepo.findById(id);
		if(income.isPresent()) {
			System.out.println("CUSTOMER IS PRESENT");
			return income.get();
		} else {
			System.out.println("CUSTOMER DOESNT EXIST, NEEDS TO BE CREATE ACCOUNT");
			return null;
		}
	}
	
	public PropertyAndIncome addCustomerIncome(PropertyAndIncome income) {
		Optional<PropertyAndIncome> search = Optional.ofNullable(findCustomerIncomeById(income.getPiId()));
		
		if(search.isPresent()) {
			return null;
		} else {
			return updateCustomerIncome(income);
		}
	}
	
	public PropertyAndIncome updateCustomerIncome(PropertyAndIncome income) {
		return propertyAndIncomeRepo.save(income);
	}
}
