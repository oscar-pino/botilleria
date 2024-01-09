package com.myprojects.botilleria.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="producto_id", nullable=false)
	private Long idProduct;
	
	@Column(nullable=false, length=20)
	@Size(min = 3,max = 20,message = " *debe ingresar nombre de producto")
	private String name;
	
	@Column(nullable=false, length=20)
	@Size(min = 3,max = 20,message = " *debe ingresar marca de producto")
	private String brand;
	
	@Min(value = 0, message = " *debe ingresar solo valores positivos")
	private int stock;
	
	@Min(value = 1000, message = " *el valor minimo del producto es 1000")
	private int price;
	
	@NotNull()
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(nullable = false)
	@Past(message = " *la fecha debe ser anterior, a la fecha actual")
	private Date admissionDate;	
	
	@ManyToOne
	@NotNull()
	private Image image;
	
	public Product() {
		
		this.admissionDate=new Date();
	}	
	
	public Product(String name, String brand, int stock, int price, Date admissionDate, Image image) {
		
		this.name = name;
		this.brand = brand;
		this.stock = stock;
		this.price = price;
		this.admissionDate = admissionDate;
		this.image = image;
	}

	public Long getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Product [idProducto=" + idProduct + ", nombre=" + name + ", marca=" + brand + ", stock=" + stock
				+ ", precio=" + price + ", fechaIngreso=" + admissionDate + ", imagen=" + image + "]";
	}	
}
