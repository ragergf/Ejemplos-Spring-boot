package com.innovandotek.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_product")
	private Long idProduct;
	
	@Column(name="name")
	@Size(min=5, max= 60)
	private String name;
	
	@Column(name="code")
	private String code;
	
	@Column(name="price")
	private Double price;
	
	@ManyToOne
	@JoinColumn(name="id_category")
	private Category category;
	
	@Column(name="description")
	private String description;

	public Product() {
		super();
	}

	public Product(Product product) {
		super();
		this.idProduct = product.idProduct;
		this.name = product.name;
		this.code = product.code;
		this.price = product.price;
		this.category = product.category;
		this.description = product.description;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	
	
}
