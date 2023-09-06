package com.example.qualcobackend.model;

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
@Table(name = "country_languages")
public class CountryLanguageEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer country_id;
  private Integer language_id;
  private Boolean official;
}
