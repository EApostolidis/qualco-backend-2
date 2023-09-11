package com.example.qualcobackend.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.qualcobackend.model.dto.Region;
import com.example.qualcobackend.repository.RegionRepository;

@Service
public class RegionService {

  private final RegionRepository regionRepository;

  public RegionService(RegionRepository regionRepository) {
    this.regionRepository = regionRepository;
  }

  @Cacheable(value = "fetchAllRegions")
  public List<Region> fetchAllRegions(){
    return regionRepository.findAllByOrderByName();
  }
}
