package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.PhoneNumber;

public interface IPhoneNumberRepo extends JpaRepository<PhoneNumber, Long> {
}
