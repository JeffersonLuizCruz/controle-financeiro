package com.project.ifood.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
@Entity
public class ProductPhoto implements Serializable{
	private static final long serialVersionUID = 629318006766287186L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "file_name")
	private String fileName;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "content_type")
	private String contentType;
	
	@Column(name = "size_path")
	private String size;
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY) 
	@JoinColumn(unique = true, nullable = false)
	private Product product;
	
	@JsonIgnore
	public Long getRestaurantId() {
		if(getProduct() != null) {
			return getProduct().getRestaurant().getId();
		}
		return null;
	}
}
