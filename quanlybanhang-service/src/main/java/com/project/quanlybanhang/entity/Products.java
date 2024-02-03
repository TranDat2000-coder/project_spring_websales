package com.project.quanlybanhang.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Products extends BaseEntity {

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
	private Category categoryId;
}
