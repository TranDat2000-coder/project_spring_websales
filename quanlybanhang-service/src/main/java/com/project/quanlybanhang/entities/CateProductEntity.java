package com.project.quanlybanhang.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "CATEGORY_PRODUCT")
@Data
public class CateProductEntity extends BaseEntity {

	@Column
	private String name;
	
	@Column
	private String code;
	
	@Column(name = "content", length = 100)
	private String content;
	
	@OneToMany(mappedBy = "categoryId", cascade = CascadeType.ALL)
	private List<ProductsEntity> product = new ArrayList<>();
}
