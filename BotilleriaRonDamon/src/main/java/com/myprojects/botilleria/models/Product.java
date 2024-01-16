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
	@NotNull(message = "debe ingresar un nombre de producto" )
	private String name;
	
	@Column(nullable=false, length=20)
	@Size(min = 3,max = 20,message = " *debe ingresar marca de producto")
	@NotNull(message = "debe ingresar una marca" )
	private String brand;
	
	@Min(value = 0, message = " *debe ingresar solo valores positivos")
	@NotNull(message = "debe ingresar un valor positivo" )
	private int stock;
	
	@Min(value = 1000, message = " *el valor minimo para el producto es 1000")
	@NotNull(message = "debe ingresar un valor positivo" )
	private int price;
	
	@Temporal(TemporalType.DATE)
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(nullable = false)
	private Date admissionDate;	
	
	@ManyToOne
	@NotNull
	private MyImage myImage;
	
	public Product() {		
		
	}	
	
	public Product(String name, String brand, int stock, int price, Date admissionDate, MyImage myImage) {
		
		this.name = name;
		this.brand = brand;
		this.stock = stock;
		this.price = price;
		this.admissionDate = admissionDate;
		this.myImage = myImage;
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
	public MyImage getImage() {
		return myImage;
	}
	public void setImage(MyImage myImage) {
		this.myImage = myImage;
	}

	@Override
	public String toString() {
		return "Product [idProducto=" + idProduct + ", nombre=" + name + ", marca=" + brand + ", stock=" + stock
				+ ", precio=" + price + ", fechaIngreso=" + admissionDate + ", imagen=" + myImage + "]";
	}	
}
