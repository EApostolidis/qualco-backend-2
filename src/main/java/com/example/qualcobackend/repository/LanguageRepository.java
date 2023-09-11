package com.example.qualcobackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.qualcobackend.model.dto.Language;
import com.example.qualcobackend.model.entity.LanguageEntity;

@Repository
public interface LanguageRepository extends JpaRepository<LanguageEntity, Integer> {

  @Query(value = "SELECT l.language as language " +
      "FROM languages l " +
      "JOIN country_languages cl ON cl.language_id = l.language_id " +
      "WHERE cl.country_id = :countryId ", nativeQuery = true)
  List<Language> findSpokenLanguagesPerCountryId(@Param("countryId") Integer countryId);

}
