package com.myprojects.botilleria.controllers;

import java.io.IOException;
import java.util.Date;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.myprojects.botilleria.models.Product;
import com.myprojects.botilleria.repositories.IProductRepository;
import com.myprojects.botilleria.services.ImageServiceImp;
import com.myprojects.botilleria.services.ProductServiceImp;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductServiceImp ps;
	
	@Autowired
	private IProductRepository pr;

	@Autowired
	private ImageServiceImp is;
	
	private int size = 0;

	@ModelAttribute("prod")
	public Product getProducto() {

		return new Product();
	}

	@GetMapping("/create")
	public String register(Model model) {

		model.addAttribute("images", is.getImagesOfDrinks());

		return "register_product";
	}

	@PostMapping("/create")
	public String register(@Valid @ModelAttribute("prod") Product pro, BindingResult br, Model model) {

		model.addAttribute("images", is.getImagesOfDrinks());
		
		if (!br.hasErrors()) {				
		
			pro.setAdmissionDate(new Date());
			ps.create(pro);
			
			size = ps.readAll().size();

			if (size > 0) {
				
				model.addAttribute("products", ps.readAll());			
				
				model.addAttribute("size", size);
			}

			return "list_products";

		} else {
			
			return "register_product";
		}
		
	}

	@GetMapping("/read_all")
	public String list(Model model) {		

		size = ps.readAll().size();

		if (size > 0)
			model.addAttribute("products", pr.findAll());

		model.addAttribute("size", size);		
		return "list_products";
	}

	@PostMapping("/edit")
	public String editar(HttpServletRequest request, Model model) {
		
			String capture = request.getParameter("ids");
			Long id = Long.parseLong(capture);

			if (ps.readById(id) != null) {

				model.addAttribute("images", is.getImagesOfDrinks());

				model.addAttribute("pro", ps.readById(id));

			}

			return "modify_product";		
	}

	@PostMapping("/update")
	public String actualizar(@Valid @ModelAttribute("prod") Product pro, BindingResult br, Model model) {

		model.addAttribute("images", is.getImagesOfDrinks());
		
		if (!br.hasErrors()) {
			
			long id = pro.getIdProduct();
			Product prod = ps.readById(id);
			pro.setAdmissionDate(prod.getAdmissionDate());
			ps.create(pro);

			size = ps.readAll().size();

			if (size > 0)
				model.addAttribute("products", ps.readAll());
			
			model.addAttribute("size", size);

			return "list_products";

		} else {
			return "modify_product";
		}
	}

	@PostMapping("/remove")
	public String eliminar(Model model, HttpServletRequest request) throws IOException {
	
			String capture = request.getParameter("ids");

			String[] ids = capture.split(",");

			for (String id : ids)
				ps.deleteById(Long.parseLong(id));
			
			model.addAttribute("products", ps.readAll());
			
			size = ps.readAll().size();
			model.addAttribute("size", size);

			return "list_products";
	}
	

	@GetMapping("automatic_products")
	public String automaticos(Model model) {

		for (Product p : ps.generateProductsAutomatically())
			ps.create(p);

		size = ps.readAll().size();

		if (size > 0) {

			model.addAttribute("products", ps.readAll());
			model.addAttribute("size", size);

		}

		return "list_products";
	}
	
}
