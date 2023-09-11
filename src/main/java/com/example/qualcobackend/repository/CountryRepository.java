package com.example.qualcobackend.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.qualcobackend.model.dto.Country;
import com.example.qualcobackend.model.dto.CountryStats;
import com.example.qualcobackend.model.dto.SearchResult;
import com.example.qualcobackend.model.entity.CountryEntity;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, Integer> {

  List<Country> findAllByOrderByNameAsc();

  @Query(value = "SELECT c.name, c.country_code3 as countryCode3, cs.year, cs.gdp, cs.population " +
      "FROM countries c " +
      "JOIN country_stats cs ON c.country_id = cs.country_id " +
      "WHERE (cs.gdp / cs.population) = (" +
      "SELECT MAX(cs_inner.gdp / cs_inner.population) " +
      "FROM country_stats cs_inner " +
      "WHERE cs_inner.country_id = cs.country_id)", nativeQuery = true)
  List<CountryStats> fetchAllCountriesWithTheirMaxGdpPerPopulation();

  @Query(value = "SELECT cnt.name as continentName, r.name as regionName, cs.year, cs.population, cs.gdp, c.name as countryName " +
      "FROM countries c " +
      "JOIN country_stats cs ON c.country_id = cs.country_id " +
      "JOIN regions r ON r.region_id = c.region_id " +
      "JOIN continents cnt ON cnt.continent_id = r.continent_id " +
      "WHERE (:fromYear IS NULL OR cs.year >= :fromYear) AND (:toYear IS NULL OR cs.year <= :toYear) AND (:regionId IS NULL OR r.region_id = :regionId)",
      countQuery = "SELECT count(*) FROM countries c " +
          "JOIN country_stats cs ON c.country_id = cs.country_id " +
          "JOIN regions r ON r.region_id = c.region_id " +
          "JOIN continents cnt ON cnt.continent_id = r.continent_id " +
          "WHERE (:fromYear IS NULL OR cs.year >= :fromYear) AND (:toYear IS NULL OR cs.year <= :toYear) AND (:regionId IS NULL OR r.region_id = :regionId)",
      nativeQuery = true)
  Page<SearchResult> fetchSearchResults(@Param("regionId") Integer regionId,
      @Param("fromYear") Integer fromYear,
      @Param("toYear") Integer toYear,
      Pageable pageable);
}
