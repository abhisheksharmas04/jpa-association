package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.IPersonRepo;
import com.example.demo.repo.IPhoneNumberRepo;

@Service
public class PersonManagementServiceImpl implements IPersonManagement{
	
	@Autowired
	private IPersonRepo personRepo;
	@Autowired
	private IPhoneNumberRepo phoneNumberRepo;
	
	@Override
	public List<Object[]> fetchDataByJoinsUsingParent() {
		return personRepo.fetchDataUsingJoinsByParent();
	}
}
