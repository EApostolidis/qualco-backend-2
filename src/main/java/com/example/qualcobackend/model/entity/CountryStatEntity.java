package com.example.qualcobackend.model.entity;

import java.math.BigDecimal;

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
@Table(name = "country_stats")
public class CountryStatEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer country_id;
  private Integer year;
  private Integer population;
  private BigDecimal gdp;
}
