package com.myprojects.botilleria.services;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myprojects.botilleria.models.Image;
import com.myprojects.botilleria.repositories.IImageRepository;

@Service
public class ImageServiceImp implements IOperations<Image> {

	@Autowired
	private IImageRepository ir;

	@Override
	public void create(Image image) {

		ir.save(image);
	}

	@Override
	public Image readById(Long id) {

		return ir.findByIdImage(id);
	}

	@Override
	public List<Image> readAll() {

		return ir.findAll();
	}

	@Override
	public void update(Image image) {

		ir.save(image);
	}

	@Override
	public void delete(Image image) {

		ir.delete(image);

	}

	@Override
	public void deleteById(Long id) {

		ir.deleteById(id);
	}

	public void uploadImages() {

		Image image = null;
		String imagePath = "src/main/resources/static/img/";
		File f = new File(imagePath);

		for (String name : f.list()) {
			image = new Image();
			image.setRout(imagePath);
			image.setName(name);

			ir.save(image);
		}
	}
	
	public ArrayList<Image> getImagesOfDrinks() {

		ArrayList<Image> images = new ArrayList<Image>();

		for (Image img : ir.findAll()) {

			if (!img.getName().equals("banner.png") & !img.getName().equals("error.png")
					& !img.getName().equals("logo.png"))
				images.add(img);
		}

		return images;
	}
}
