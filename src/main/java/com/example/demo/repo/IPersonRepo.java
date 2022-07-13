package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Person;

public interface IPersonRepo extends JpaRepository<Person, Integer> {
//	@Query("SELECT p.pid, p.pname, p.paddress, ph.regno, ph.phoneNo from Person p inner join p.phones ph")
	@Query("SELECT p.pid, p.pname, p.paddress, ph.regno, ph.phoneNo from Person p right join p.phones ph")
	public List<Object[]>fetchDataUsingJoinsByParent();

}
