package com.griddnamics.gridu.spring.qa.phonebook.service;

import com.griddnamics.gridu.spring.qa.phonebook.entity.PhoneBookRecord;

import java.util.List;

public interface PhoneBookService {
    List<PhoneBookRecord> getAllRecords();

    List<PhoneBookRecord> getPhonesByName(String name);

    PhoneBookRecord addPhoneToName(String name, String phoneNumber);

    PhoneBookRecord createRecord(String name, String phoneNumber);

    void deleteByName(String name);
}
