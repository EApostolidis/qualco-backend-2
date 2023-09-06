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
@Table(name = "guests")
public class GuestEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer guest_id;
  private String name;
}
