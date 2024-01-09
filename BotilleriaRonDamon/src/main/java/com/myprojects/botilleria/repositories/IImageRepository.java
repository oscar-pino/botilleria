package com.myprojects.botilleria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myprojects.botilleria.models.Image;

public interface IImageRepository extends JpaRepository<Image,Long>{

	Image findByIdImage(Long id);
	List<Image> findAll();
}

