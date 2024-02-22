package org.example.javalab.controller;

import org.example.javalab.service.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }
    @GetMapping("/numbers")
    public DTO process(@RequestParam String text){
        List<String> numbersList = service.extractPhoneNumbers(text);
        List<String> emailsList = service.extractEmails(text);
        return new DTO(numbersList,emailsList);
    }

}
