package com.example.qualcobackend.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.qualcobackend.model.dto.Country;
import com.example.qualcobackend.model.dto.CountryStats;
import com.example.qualcobackend.repository.CountryRepository;

@Service
public class CountryService {

  private final CountryRepository countryRepository;

  public CountryService(CountryRepository countryRepository) {
    this.countryRepository = countryRepository;
  }

  @Cacheable(value = "fetchAllCountries")
  public List<Country> fetchAllCountries() {
    return countryRepository.findAllByOrderByNameAsc();
  }

  @Cacheable(value = "fetchAllCountriesWithTheirMaxGdpPerPopulation")
  public List<CountryStats> fetchAllCountriesWithTheirMaxGdpPerPopulation() {
    return countryRepository.fetchAllCountriesWithTheirMaxGdpPerPopulation();
  }
}
