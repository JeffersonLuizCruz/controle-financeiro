package com.project.ifood.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
@Embeddable
public class Address implements Serializable{
	private static final long serialVersionUID = 5326589699480137859L;
	
	@Column(name = "address_cep")
	private String cep;
	@Column(name = "address_street")
	private String street;
	@Column(name = "address_number")
	private String number;
	@Column(name = "address_coplement")
	private String complement;
	@Column(name = "address_district")
	private String district;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_city_id")
	private City city;
}
