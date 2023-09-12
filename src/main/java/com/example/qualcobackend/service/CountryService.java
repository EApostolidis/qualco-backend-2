package com.example.qualcobackend.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.qualcobackend.model.dto.Country;
import com.example.qualcobackend.model.dto.CountryStats;
import com.example.qualcobackend.model.dto.SearchResult;
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

  public Page<SearchResult> searchCountryStats(Integer fromYear, Integer toYear, Integer regionId, Pageable pageable) {
    if (fromYear != null && toYear != null && fromYear > toYear) {
      throw new RuntimeException("fromYear must not be greater than toYear");
    }
    return countryRepository.fetchSearchResults(regionId, fromYear, toYear, pageable);
  }
}
