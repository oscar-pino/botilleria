package com.myprojects.botilleria.services;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myprojects.botilleria.models.Product;
import com.myprojects.botilleria.repositories.IImageRepository;
import com.myprojects.botilleria.repositories.IProductRepository;

@Service
public class ProductServiceImp implements IOperations<Product> {

	@Autowired
	private IProductRepository pr;

	@Autowired
	private IImageRepository ir;

	@Override
	public void create(Product prod) {

		pr.save(prod);

	}

	@Override
	public Product readById(Long id) {

		return pr.findById(id).get();
	}

	@Override
	public List<Product> readAll() {

		return pr.findAll();
	}

	@Override
	public void update(Product product) {

		pr.save(product);
	}

	@Override
	public void delete(Product product) {

		pr.delete(product);

	}

	@Override
	public void deleteById(Long id) {

		pr.deleteById(id);

	}

	public Product[] generateProductsAutomatically() {

		Product[] products = {

				new Product("cocacola", "ccu", 12, 1200, getDate(), ir.findAll().get(4)),
				new Product("fanta", "ccu", 12, 1200, getDate(), ir.findAll().get(3)),
				new Product("sprite", "ccu", 12, 1200, getDate(), ir.findAll().get(10)),
				new Product("cachantun", "cachantun", 12, 1200, getDate(), ir.findAll().get(0)),
				new Product("vino", "gato", 15, 1500, getDate(), ir.findAll().get(5)),
				new Product("papaya", "whatss", 12, 1200, getDate(), ir.findAll().get(8)),
				new Product("blackron", "casillero", 15, 1500, getDate(), ir.findAll().get(12))

		};

		return products;
	}

	private static Date getDate() {

		Date fo = new Date();
		Date date = new Date();

		do {

			int[] fecha = { 2023, generateRandom(0, 11), generateRandom(0, 28) };

			date = new Date(fecha[0],fecha[1],fecha[2]);

		} while (date.after(new Date(fo.getYear(),fo.getMonth(),fo.getDay())));

		return date;
	}

	private static int generateRandom(int min, int max) {

		Random rd = new Random();

		return rd.nextInt(((max - min) + 1) + min);
	}

}
