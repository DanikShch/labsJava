package org.example.javalab.service;

import org.example.javalab.dao.NumberDao;
import org.example.javalab.dao.NumberEntity;
import org.springframework.boot.autoconfigure.domain.EntityScan;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@org.springframework.stereotype.Service
@EntityScan("org.example.javalab.dao")
public class Service {
    private final NumberDao numberDao;

    public Service(NumberDao numberDao) {
        this.numberDao = numberDao;
    }
    public List<String> extractPhoneNumbers(String text) {
        List<String> phoneNumbers = new ArrayList<>();
        // Паттерн для поиска номеров телефонов
        Pattern pattern = Pattern.compile("\\+?[0-9\\-]{7,}");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            phoneNumbers.add(matcher.group());
        }
        for (String phoneNumber : phoneNumbers) {
            numberDao.saveEntity(new NumberEntity(phoneNumber));
        }
        return phoneNumbers;
    }

    public List<String> extractEmails(String text) {
        List<String> emails = new ArrayList<>();
        // Паттерн для поиска email'ов
        Pattern pattern = Pattern.compile("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            emails.add(matcher.group());
        }
        return emails;
    }
}
