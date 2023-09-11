package com.example.qualcobackend.model.entity;

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
@Table(name = "country_languages")
public class CountryLanguageEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "country_id")
  private Integer countryId;
  @Column(name = "language_id")
  private Integer languageId;
  private Boolean official;
}
