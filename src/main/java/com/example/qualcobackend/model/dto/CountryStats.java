package com.example.qualcobackend.model.dto;

import java.math.BigDecimal;

public interface CountryStats {

  String getName();
  Integer getYear();
  String getCountryCode3();
  Integer getPopulation();
  BigDecimal getGdp();
}
