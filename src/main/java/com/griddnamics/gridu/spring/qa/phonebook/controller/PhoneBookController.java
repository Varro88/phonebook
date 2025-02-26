package com.griddnamics.gridu.spring.qa.phonebook.controller;

import com.griddnamics.gridu.spring.qa.phonebook.entity.PhoneBookRecord;
import com.griddnamics.gridu.spring.qa.phonebook.service.PhoneBookServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
    public PhoneBookRecord createRecord(@RequestBody PhoneBookRecord record) {
        return service.createRecord(record.getName(), record.getPhoneNumber());
    }

    @DeleteMapping("/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByName(@PathVariable String name) {
        service.deleteByName(name);
    }
}
