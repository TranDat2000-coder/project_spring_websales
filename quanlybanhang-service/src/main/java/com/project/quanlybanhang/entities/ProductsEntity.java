package com.project.quanlybanhang.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "products")
public class ProductsEntity extends BaseEntity {

	@Column(name = "namephone")
	private String namePhone;
	
	@Lob
	@Column(name = "image")
	private byte[] image;

	@Column(name = "short_discription")
	private String shortDiscription; //Mô tả ngắn

	@Column(name = "description")
	private String description;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "price_sale")
	private Double priceSale;
	
	@Column(name = "systems")
	private String system; //Hệ điều hành

	@Column(name = "cpu")
	private String cpu;

	@Column(name = "ram")
	private Integer ram;

	@Column(name = "memory_in")
	private Integer memoryIn; //Bộ nhớ trong

	@Column(name = "capacity_pin")
	private Integer capacityPin; //Dung lượng pin

	@ManyToOne
	@JoinColumn(name = "cate_id")
	private CateProductEntity categoryId;
}
