package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Email;
import com.example.demo.service.EmailService;

@RestController
@RequestMapping("/enquiry")
@CrossOrigin(origins = "http://localhost:5173")
public class EmailController {

    @Autowired
    EmailService service;

    @PostMapping("/email")
    public ResponseEntity<String> saveContact(
            @RequestBody Email email) {

        service.saveInfo(email);

        return new ResponseEntity<>(
                "Enquiry Submitted Successfully",
                HttpStatus.OK
        );
    }
}