package com.myprojects.botilleria.services;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myprojects.botilleria.models.MyImage;
import com.myprojects.botilleria.repositories.IImageRepository;

@Service
public class ImageServiceImp implements IOperations<MyImage> {

	@Autowired
	private IImageRepository ir;

	@Override
	public void create(MyImage myImage) {

		ir.save(myImage);
	}

	@Override
	public MyImage readById(Long id) {

		return ir.findByIdImage(id);
	}

	@Override
	public List<MyImage> readAll() {

		return ir.findAll();
	}

	@Override
	public void update(MyImage myImage) {

		ir.save(myImage);
	}

	@Override
	public void delete(MyImage myImage) {

		ir.delete(myImage);

	}

	@Override
	public void deleteById(Long id) {

		ir.deleteById(id);
	}

	public void uploadImages() {

		MyImage myImage = null;
		String imagePath = "src/main/resources/static/img/";
		File f = new File(imagePath);

		for (String name : f.list()) {
			myImage = new MyImage();
			myImage.setRout(imagePath);
			myImage.setName(name);

			ir.save(myImage);
		}
	}
	
	public ArrayList<MyImage> getImagesOfDrinks() {

		ArrayList<MyImage> myImages = new ArrayList<MyImage>();

		for (MyImage img : ir.findAll()) {

			if (!img.getName().equals("banner.png") & !img.getName().equals("error.png")
					& !img.getName().equals("logo.png"))
				myImages.add(img);
		}

		return myImages;
	}
}
