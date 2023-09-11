package com.example.qualcobackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.qualcobackend.model.dto.Region;
import com.example.qualcobackend.model.entity.RegionEntity;

public interface RegionRepository extends JpaRepository<RegionEntity, Integer> {

  List<Region> findAllByOrderByName();

}
