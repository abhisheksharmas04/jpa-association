package com.example.demo.runner;

import java.util.HashSet;
import java.util.Set;

import org.apache.tomcat.websocket.PojoHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Person;
import com.example.demo.entity.PhoneNumber;
import com.example.demo.service.IPersonManagement;

@Component
public class AssociationTestRunner implements CommandLineRunner {

	@Autowired
	private IPersonManagement service;

	@Override
	public void run(String... args) throws Exception {
		/*// Save operation parent to child
		//parepare object having associcated child objects
		//child object
		PhoneNumber phoneNumber1 = new PhoneNumber(9999999L,"airtel","office");
		PhoneNumber phoneNumber2 = new PhoneNumber(8888888L,"Voda","residence");
		//Set<PhoneNumber>phonSet =  Set.of(phoneNumber1,phoneNumber2);
		
		//parent object
		Person person1 = new Person("Rajesh", "Jpr");
		// parent to child
		phoneNumber1.setPerson(person1);
		phoneNumber2.setPerson(person1);
		//set child to parent
		Set<PhoneNumber>phoneSet = new HashSet<>();
		phoneSet.add(phoneNumber1);
		phoneSet.add(phoneNumber2);
		person1.setPhones(phoneSet);
		
		// invoke service method
		System.out.println(service.savePerson(person1));*/

		/*//---------------------------------------------------------------------------------------------------
		// save operation child to parent
		PhoneNumber ph1 = new PhoneNumber(77777777L,"Jio","Office");
		PhoneNumber ph2 = new PhoneNumber(66666666L,"Voda","Office");
		
		// parent object
		Person per = new Person("Karan","hyd");
		// add parent to child
		ph1.setPerson(per); ph2.setPerson(per);
		// add childs to parent
		Set<PhoneNumber>phoneSet = Set.of(ph1,ph2);
		per.setPhones(phoneSet);
		
		System.out.println(service.savePhoneNumbers(phoneSet));*/

		/*//---------------------------------------------------------------------------------------------------
		//Load operation parent to child
		service.fetchByPerson().forEach(per ->{
			System.out.println("parent: " + per);
			Set<PhoneNumber>childs = per.getPhones();
			childs.forEach(cph->{
				System.out.println("child:: " + cph);
			});
		});*/

		/*//---------------------------------------------------------------------------------------------------
		// Load operation child to parent
		service.fetchByPhoneNumber().forEach(ph->{
			System.out.println("Child : " + ph);
			Person per = ph.getPerson();
			System.out.println("Parent: " + per);
		});*/
		
		/*//---------------------------------------------------------------------------------------------------
		// delete by parent operation
		System.out.println(service.deleteByPerson(42));
		*/
		
		//---------------------------------------------------------------------------------------------------
				// delete by child operation
		System.out.println(service.deletePhoneNumbers(44));
	}

}
