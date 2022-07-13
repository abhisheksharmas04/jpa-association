package com.example.demo.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.service.IPersonManagement;

@Component
public class AssociationTestRunner implements CommandLineRunner {

	@Autowired
	private IPersonManagement service;

	@Override
	public void run(String... args) throws Exception {
		service.fetchDataByJoinsUsingParent().forEach(row ->{
			for(Object val: row) {
				System.out.print(val + "");
			}
			System.out.println();
		});
	}

}
