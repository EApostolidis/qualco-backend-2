package com.example.qualcobackend.model.dto;

import java.math.BigDecimal;

public interface SearchResult {

  String getContinentName();
  String getRegionName();
  String getCountryName();
  Integer getYear();
  Integer getPopulation();
  BigDecimal getGdp();
}
