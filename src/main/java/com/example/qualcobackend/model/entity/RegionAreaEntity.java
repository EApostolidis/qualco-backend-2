package com.example.qualcobackend.model.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "region_areas")
public class RegionAreaEntity {

  @Id
  private String region_name;
  private BigDecimal region_area;

}
