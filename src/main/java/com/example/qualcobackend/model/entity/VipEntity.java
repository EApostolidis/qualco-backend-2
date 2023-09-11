package com.example.qualcobackend.model.entity;

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
@Table(name = "vips")
public class VipEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer vip_id;
  private String name;
}
