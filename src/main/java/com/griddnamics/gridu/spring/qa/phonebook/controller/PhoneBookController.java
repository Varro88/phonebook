package com.griddnamics.gridu.spring.qa.phonebook.controller;

import com.griddnamics.gridu.spring.qa.phonebook.entity.PhoneBookRecord;
import com.griddnamics.gridu.spring.qa.phonebook.service.PhoneBookServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/contacts")
public class PhoneBookController {
    private final PhoneBookServiceImpl service;

    public PhoneBookController(PhoneBookServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public List<PhoneBookRecord> getAllRecords() {
        return service.getAllRecords();
    }

    @GetMapping("/{name}")
    public List<PhoneBookRecord> getPhonesByName(@PathVariable String name) {
        return service.getPhonesByName(name);
    }

    @PutMapping("/{name}")
    public PhoneBookRecord addPhoneToName(@PathVariable String name, @RequestBody PhoneBookRecord record) {
        return service.addPhoneToName(name, record.getPhoneNumber());
    }

    @PostMapping
    public ResponseEntity<PhoneBookRecord> createRecord(@RequestBody PhoneBookRecord record) {
        PhoneBookRecord saved = service.createRecord(record.getName(), record.getPhoneNumber());
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteByName(@PathVariable String name) {
        service.deleteByName(name);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
    }
}
