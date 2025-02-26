package com.griddnamics.gridu.spring.qa.phonebook.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Entity
@Slf4j
@Data
public class PhoneBookRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private String phoneNumber;
}
