package com.myprojects.botilleria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myprojects.botilleria.models.MyImage;

public interface IImageRepository extends JpaRepository<MyImage,Long>{

	MyImage findByIdImage(Long id);
	List<MyImage> findAll();
}

