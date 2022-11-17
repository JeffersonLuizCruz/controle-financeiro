package com.financial.porkinho.domain.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
@Embeddable
public class Address implements Serializable{
	private static final long serialVersionUID = 5326589699480137859L;
	
	private String cep;
	private String street;
	private String number;
	private String complement;
	private String district;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
}
