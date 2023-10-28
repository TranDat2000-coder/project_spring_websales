package com.project.quanlybanhang.entity;

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
public class Category extends BaseEntity {

	@Column
	private String name;
	
	@Column
	private String code;
	
	@Column(name = "content", length = 100)
	private String content;
	
	@OneToMany(mappedBy = "categoryId", cascade = CascadeType.ALL)
	private List<Products> product = new ArrayList<>();
}
