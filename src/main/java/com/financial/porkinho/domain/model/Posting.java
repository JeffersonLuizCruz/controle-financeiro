package com.financial.porkinho.domain.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.financial.porkinho.domain.model.enums.Signal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class Posting implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	
	private Signal signal;
	
	@ManyToOne
	@JoinColumn(name = "institution_id")
	private Institution institution;
	
	@ManyToOne
	@JoinColumn(name = "donation_id")
	private Donation donation;
	
	@ManyToOne
	@JoinColumn(name = "bank_account_id")
	private BankAccount bankAccount;
	
	@ManyToOne
	@JoinColumn(name = "bank_balance_id")
	private BankBalance bankBalance;
}
