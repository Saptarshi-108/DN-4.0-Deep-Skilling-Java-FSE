package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CountryService {
    @Autowired
    private ApplicationContext context;

    public Country getCountry(String code) {
        Map<String, Country> countryBeans = context.getBeansOfType(Country.class);
        List<Country> countryList = new ArrayList<>(countryBeans.values());
        return countryList.stream()
                .filter(c -> c.getCode() != null && c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Country not found for code: " + code));
    }
}
