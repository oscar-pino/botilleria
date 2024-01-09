package com.myprojects.botilleria.services;

import java.util.List;

public interface IOperations<T> {

	void create(T t);

	T readById(Long id);

	List<T> readAll();

	void update(T t);

	void delete(T t);
	
	void deleteById(Long id);
}
