package com.example.demo.service;

import com.example.demo.entity.Person;
import com.example.demo.entity.PhoneNumber;

public interface IPersonManagement {
	public String savePerson(Person per);
	public String savePhoneNumbers(Iterable<PhoneNumber> phones);
	public Iterable<Person>fetchByPerson();
	public Iterable<PhoneNumber>fetchByPhoneNumber();
	public String deleteByPerson(int per);
	public String deletePhoneNumbers(int personId);

}
