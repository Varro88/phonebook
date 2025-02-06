package com.griddnamics.gridu.spring.qa.phonebook.repository;

import com.griddnamics.gridu.spring.qa.phonebook.entity.PhoneBookRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PhoneBookRepository extends JpaRepository<PhoneBookRecord, Long> {
    List<PhoneBookRecord> findByName(String name);
    int deleteByName(String name);
}
