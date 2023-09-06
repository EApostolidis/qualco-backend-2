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
@Table(name = "regions")
public class RegionEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer region_id;
  private String name;
  private Integer continent_id;
}
