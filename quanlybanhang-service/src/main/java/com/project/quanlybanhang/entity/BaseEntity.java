package com.project.quanlybanhang.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.project.quanlybanhang.repository.CateProductRepository;
import com.project.quanlybanhang.service.ICateProductService;
import com.project.quanlybanhang.service.IProductService;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	@CreatedDate
	private Date createDate;
	
	@Column
	@LastModifiedDate
	private Date modifiedDate;
	
	@Column
	@CreatedBy
	private String createBy;
	
	@Column
	@LastModifiedBy
	private String modifiedBy;
}
