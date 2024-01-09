package com.myprojects.botilleria.controllers;

import java.io.IOException;
import java.util.ArrayList;

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

import com.myprojects.botilleria.models.Image;
import com.myprojects.botilleria.models.Product;
import com.myprojects.botilleria.repositories.IImageRepository;
import com.myprojects.botilleria.services.ImageServiceImp;
import com.myprojects.botilleria.services.ProductServiceImp;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductServiceImp ps;

	@Autowired
	private ImageServiceImp is;

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

		if (!br.hasErrors()) {

			int size = 0;

			ps.create(pro);

			size = ps.readAll().size();

			if (size > 0)
				model.addAttribute("products", ps.readAll());

			model.addAttribute("size", size);

			return "list_products";

		} else {
			return "error";
		}
	}

	@GetMapping("/read_all")
	public String list(Model model) {

		int size = 0;

		size = ps.readAll().size();

		if (size > 0)
			model.addAttribute("products", ps.readAll());

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

		if (!br.hasErrors()) {

			int size = 0;
			long id = pro.getIdProduct();
			Product prod = ps.readById(id);

			ps.create(pro);

			size = ps.readAll().size();

			if (size > 0)
				model.addAttribute("products", ps.readAll());

			model.addAttribute("size", size);

			return "list_products";

		} else {
			return "error";
		}
	}

	@PostMapping("/remove")
	public String eliminar(Model model, HttpServletRequest request) throws IOException {
	
			String capture = request.getParameter("ids");
			int size = 0;

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

		int size = 0;

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
