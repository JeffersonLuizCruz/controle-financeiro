package com.project.ifood.domain.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class ProductPhoto implements Serializable{
	private static final long serialVersionUID = 629318006766287186L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String fileName;
	private String description;
	private String contentType;
	private String size;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(unique = true, nullable = false)
	private Product product;
}
