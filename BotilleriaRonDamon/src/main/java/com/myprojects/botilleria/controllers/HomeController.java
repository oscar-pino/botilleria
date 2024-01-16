package com.myprojects.botilleria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.myprojects.botilleria.repositories.IImageRepository;
import com.myprojects.botilleria.repositories.IProductRepository;
import com.myprojects.botilleria.services.*;

@Controller
public class HomeController {
	
	@Autowired
	private IProductRepository pr;
	
	@Autowired
	private ImageServiceImp is;
	
	@Autowired
	private IImageRepository ir;
	
	@GetMapping({"/","/index","/home"})
	public String inicio(Model model) {		
		
		if(ir.findAll().size() == 0)
			is.uploadImages();
		
		return "index";		
	}
	
	@GetMapping("/contact")
	public String getContact() {
		
		return "contact";
	}
}
