package com.example.qualcobackend.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "countries")
public class CountryEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "country_id")
  private Integer countryId;
  private String name;
  private BigDecimal area;
  private LocalDate national_day;
  @Column(name = "country_code2", columnDefinition = "CHAR", insertable = false, updatable = false)
  private String countryCode2;
  @Column(name = "country_code3", columnDefinition = "CHAR")
  private String countryCode3;
  private Integer region_id;
}
