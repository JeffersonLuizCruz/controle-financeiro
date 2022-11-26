package com.financial.ifood.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity  @Table(name = "`group`")
public class Group implements Serializable{
	private static final long serialVersionUID = 7898832144327621719L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@ManyToMany
	@JoinTable(name = "group_role",
			joinColumns = @JoinColumn(name = "groups_id"),
			inverseJoinColumns = @JoinColumn(name = "roles_id"))
	private List<Role> roles = new ArrayList<>();
}
