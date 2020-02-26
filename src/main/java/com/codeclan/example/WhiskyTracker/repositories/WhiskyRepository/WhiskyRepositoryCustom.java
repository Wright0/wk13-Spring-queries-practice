package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Whisky;

import java.util.List;

public interface WhiskyRepositoryCustom {
     List<Whisky> findByDistilleryAndAge(Long id, int age);
     List<Whisky> findByRegion(String region);

}
