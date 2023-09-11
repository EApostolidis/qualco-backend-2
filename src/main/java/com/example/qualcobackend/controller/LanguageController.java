package com.example.qualcobackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.qualcobackend.model.dto.Language;
import com.example.qualcobackend.service.LanguageService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/languages", produces = APPLICATION_JSON_VALUE)
public class LanguageController {

  private final LanguageService languageService;

  public LanguageController(LanguageService languageService) {
    this.languageService = languageService;
  }

  @GetMapping("country/{id}")
  public ResponseEntity<List<Language>> fetchLanguagePerCountryId(@PathVariable Integer id) {
    List<Language> languages = languageService.fetchLanguagesPerCountryId(id);
    return ResponseEntity.status(HttpStatus.OK).body(languages);
  }
}
