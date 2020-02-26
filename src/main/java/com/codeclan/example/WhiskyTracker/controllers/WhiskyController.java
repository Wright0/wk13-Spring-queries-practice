package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/search/findByDistilleryAndAge")
    public List<Whisky> findByDistilleryAndAge(@RequestParam Long id, int age){
        return whiskyRepository.findByDistilleryAndAge(id, age);
    }

    @GetMapping(value = "/search/findByRegion")
    public List<Whisky> findByRegion(@RequestParam String region){
        return whiskyRepository.findByRegion("Lowland");
    }

}
