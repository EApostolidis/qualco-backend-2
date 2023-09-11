package com.example.qualcobackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.qualcobackend.model.dto.Country;
import com.example.qualcobackend.model.dto.CountryStats;
import com.example.qualcobackend.model.entity.CountryEntity;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity,Integer> {

  List<Country> findAllByOrderByNameAsc();

  @Query(value = "SELECT c.name, c.country_code3 as countryCode3, cs.year, cs.gdp, cs.population " +
      "FROM countries c " +
      "JOIN country_stats cs ON c.country_id = cs.country_id " +
      "WHERE (cs.gdp / cs.population) = (" +
      "SELECT MAX(cs_inner.gdp / cs_inner.population) " +
      "FROM country_stats cs_inner " +
      "WHERE cs_inner.country_id = cs.country_id)", nativeQuery = true)
  List<CountryStats> fetchAllCountriesWithTheirMaxGdpPerPopulation();
}
