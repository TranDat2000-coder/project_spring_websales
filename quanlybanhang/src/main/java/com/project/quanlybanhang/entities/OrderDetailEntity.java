package com.project.quanlybanhang.entities;

import javax.persistence.*;

import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "order_detail")
public class OrderDetailEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 7550745928843183535L;

	@Column(name = "amount", precision = 8)
	private Double amount;
	
	@Column(name = "price", precision = 8)
	private Double price;
	
	private Integer quanity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id", nullable = false, foreignKey = @ForeignKey(name = "ORDER_DETAIL_ORD_FK"))
	private OrdersEntity order;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", nullable = false, foreignKey = @ForeignKey(name = "ORDER_DETAIL_PROD_FK"))
	private ProductsEntity product;
}
