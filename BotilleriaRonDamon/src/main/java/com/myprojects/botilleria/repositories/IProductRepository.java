package com.myprojects.botilleria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myprojects.botilleria.models.Product;

public interface IProductRepository extends JpaRepository<Product,Long>{

	void deleteById(Long id);
}

