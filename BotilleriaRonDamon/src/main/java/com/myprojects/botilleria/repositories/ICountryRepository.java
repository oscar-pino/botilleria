package com.myprojects.botilleria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myprojects.botilleria.models.Country;

public interface ICountryRepository extends JpaRepository<Country, Long> {

}
