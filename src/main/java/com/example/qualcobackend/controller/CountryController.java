package com.example.qualcobackend.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.qualcobackend.model.dto.Country;
import com.example.qualcobackend.model.dto.CountryStats;
import com.example.qualcobackend.model.dto.SearchResult;
import com.example.qualcobackend.service.CountryService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/countries", produces = APPLICATION_JSON_VALUE)
public class CountryController {

  private final CountryService countryService;

  public CountryController(CountryService countryService) {
    this.countryService = countryService;
  }

  @GetMapping
  public ResponseEntity<List<Country>> fetchAllCountries() {
    List<Country> countries = countryService.fetchAllCountries();
    return ResponseEntity.status(HttpStatus.OK).body(countries);
  }

  @GetMapping("/stats")
  public ResponseEntity<List<CountryStats>> fetchAllCountriesWithTheirMaxGdpPerPopulation() {
    List<CountryStats> countryStats = countryService.fetchAllCountriesWithTheirMaxGdpPerPopulation();
    return ResponseEntity.status(HttpStatus.OK).body(countryStats);
  }

  @GetMapping("/search")
  public ResponseEntity<Page<SearchResult>> searchCountryStats(
      @RequestParam(required = false) Integer from,
      @RequestParam(required = false) Integer to,
      @RequestParam(required = false) Integer regionId,
      Pageable pageable) {
    Page<SearchResult> searchResults = countryService.searchCountryStats(from, to, regionId, pageable);
    return ResponseEntity.status(HttpStatus.OK).body(searchResults);
  }
}
