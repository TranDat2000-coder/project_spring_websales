package com.project.quanlybanhang.entities;

import com.project.quanlybanhang.entities.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "orders", uniqueConstraints = {@UniqueConstraint(columnNames = "order_num")})
public class OrdersEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -2576670215015463100L;

	@Column(name = "order_num", unique = true)
	private Integer oderNum;

	@Column(name = "amount", nullable = false)
	private Double amount;

	@Column(name = "customer_email", nullable = false)
	private String customerEmail;

	@Column(name = "customer_name", nullable = false)
	private String customerName;

	@Column(name = "customer_phone", nullable = false)
	private String customerPhone;
	
	@Column(name = "customer_address", nullable = false)
	private String customerAddress;

	@Column(name = "order_date", nullable = false)
	private Date orderDate;
}
