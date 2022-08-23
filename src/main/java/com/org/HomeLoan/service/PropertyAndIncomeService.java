package com.org.HomeLoan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.HomeLoan.dao.PropertyAndIncomeDao;
import com.org.HomeLoan.dto.PropertyAndIncome;

@Repository
public class PropertyAndIncomeService {

	@Autowired
	PropertyAndIncomeDao dao;
	
	public PropertyAndIncome findCustomerIncomeById(int id) {
		return dao.findCustomerIncomeById(id);
	}
	
	public PropertyAndIncome addCustomerIncome (PropertyAndIncome income) {
		return dao.addCustomerIncome(income);
	}
	
	public PropertyAndIncome updateCustomerIncome(PropertyAndIncome income) {
		return dao.updateCustomerIncome(income);
	}

}