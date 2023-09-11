package com.example.qualcobackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.qualcobackend.model.dto.Region;
import com.example.qualcobackend.service.RegionService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/regions", produces = APPLICATION_JSON_VALUE)
public class RegionController {

  private final RegionService regionService;

  public RegionController(RegionService regionService) {
    this.regionService = regionService;
  }

  @GetMapping
  public ResponseEntity<List<Region>> fetchAllRegions() {
    List<Region> regions = regionService.fetchAllRegions();
    return ResponseEntity.status(HttpStatus.OK).body(regions);
  }
}
