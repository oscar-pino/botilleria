package com.myprojects.botilleria.controllers;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myprojects.botilleria.models.Image;
import com.myprojects.botilleria.repositories.IImageRepository;
import com.myprojects.botilleria.services.ImageServiceImp;

@RestController
@RequestMapping("/api")
public class TestApi {
	
	@Autowired
	IImageRepository ir;

	@GetMapping("/dato")
	public String getImage() {
		
		//File f = new File("src/main/resources/static/img/agua.png");
//		String ruta = f.getAbsolutePath();
//		int encontrados = f.list().length;
//		
		
		Image image = null;
		String imagePath = "src/main/resources/static/img/";
		File f = new File(imagePath);
		
		for(String name : f.list())
		{
			image = new Image();
			image.setRout(imagePath);
			image.setName(name);
			
			ir.save(image);
		}
		
		if(ir.findAll().size()>0)
			return "existen imagenes";
		else
			return "No existen imagenes";
		
	}
	

}
