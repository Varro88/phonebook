package com.griddnamics.gridu.spring.qa.phonebook.service;

import com.griddnamics.gridu.spring.qa.phonebook.entity.PhoneBookRecord;
import com.griddnamics.gridu.spring.qa.phonebook.exceptions.InvalidRecordException;
import com.griddnamics.gridu.spring.qa.phonebook.exceptions.NoRecordWithProvidedNameException;
import com.griddnamics.gridu.spring.qa.phonebook.exceptions.RecordAlreadyExistsException;
import com.griddnamics.gridu.spring.qa.phonebook.repository.PhoneBookRepository;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneBookServiceImpl implements PhoneBookService {
    
    private final PhoneBookRepository repository;

    public PhoneBookServiceImpl(PhoneBookRepository repository) {
        this.repository = repository;
    }

    public List<PhoneBookRecord> getAllRecords() {
        return repository.findAll();
    }

    public List<PhoneBookRecord> getPhonesByName(String name) {
        List<PhoneBookRecord> foundRecords = repository.findByName(name);
        if (foundRecords.isEmpty()) {
            throw new NoRecordWithProvidedNameException("Name '" + name + "' not found");
        }
        return foundRecords;
    }

    @Transactional
    public PhoneBookRecord addPhoneToName(String name, String phoneNumber) {
        Optional<PhoneBookRecord> existingRecord = repository.findByName(name).stream().findFirst();
        if (existingRecord.isEmpty()) {
            throw new NoRecordWithProvidedNameException("Name '" + name + "' not found");
        }
        PhoneBookRecord record = existingRecord.get();
        record.setPhoneNumber(phoneNumber);
        return repository.save(record);
    }

    @Transactional
    public PhoneBookRecord createRecord(String name, String phoneNumber) {
        if(phoneNumber == null || phoneNumber.isEmpty()) {
            throw new InvalidRecordException("Phone number is required");
        }
        if(name == null || name.isEmpty()) {
            throw new InvalidRecordException("Name is required");
        }
        PhoneBookRecord record = new PhoneBookRecord();
        record.setName(name);
        record.setPhoneNumber(phoneNumber);
        try {
            return repository.save(record);
        } catch (DataIntegrityViolationException e) {
            throw new RecordAlreadyExistsException("A record for the name '" + name + "' already exists.");
        }
    }

    @Transactional
    public void deleteByName(String name) {
        int rowsDeleted = repository.deleteByName(name);
        if (rowsDeleted == 0) {
            throw new NoRecordWithProvidedNameException("Name '" + name + "' not found");
        }
    }
}
