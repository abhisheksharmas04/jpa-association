package com.example.demo.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Person;
import com.example.demo.entity.PhoneNumber;
import com.example.demo.repo.IPersonRepo;
import com.example.demo.repo.IPhoneNumberRepo;

@Service
public class PersonManagementServiceImpl implements IPersonManagement{
	
	@Autowired
	private IPersonRepo personRepo;
	@Autowired
	private IPhoneNumberRepo phoneNumberRepo;

	@Override
	public String savePerson(Person per) {
		int idval = personRepo.save(per).getPid();
		return "Object is saved with Id value: " + idval;
	}

	@Override
	public String savePhoneNumbers(Iterable<PhoneNumber> phonesSet) {
		for(PhoneNumber ph:phonesSet) {
			phoneNumberRepo.save(ph);
		}
		return ((Set<PhoneNumber>)phonesSet).size() + "no of records are saved";
	}

	@Override
	public Iterable<Person> fetchByPerson() {
		return personRepo.findAll();
	}

	@Override
	public Iterable<PhoneNumber> fetchByPhoneNumber() {
		return phoneNumberRepo.findAll();
	}

	@Override
	public String deleteByPerson(int perId) {
		// load parent object:
		Optional<Person>opt = personRepo.findById(perId);
		if(opt.isPresent()) {
			personRepo.delete(opt.get());
			return "Person and his phone numbers are deleted";
		}else {
			return "Person Not Found";
		}
	}

	@Override
	public String deletePhoneNumbers(int personId) {
		// load parent object:
		Optional<Person> opt = personRepo.findById(personId);
		if (opt.isPresent()) {
			// get all childs of a parent
			Set<PhoneNumber> childs = opt.get().getPhones();
			// delete all childs
			childs.forEach(ph -> {
				//ph.SetPerson(null); // relationship is broken
			});
			phoneNumberRepo.deleteAll(childs);
			return "All phone numbers of a person are deleted";
		} else {
			return "Person Not Found";
		}
	}
}
