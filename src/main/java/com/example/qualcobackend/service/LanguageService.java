package com.example.qualcobackend.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.qualcobackend.model.dto.Language;
import com.example.qualcobackend.repository.LanguageRepository;

@Service
public class LanguageService {

  private final LanguageRepository languageRepository;

  public LanguageService(LanguageRepository languageRepository) {
    this.languageRepository = languageRepository;
  }

  @Cacheable(value = "languagePerCountry", key = "#countryId")
  public List<Language> fetchLanguagesPerCountryId(Integer countryId){
    return languageRepository.findSpokenLanguagesPerCountryId(countryId);
  }
}
