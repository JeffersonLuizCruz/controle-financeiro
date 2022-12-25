package com.financial.ifood.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity(name = "`group`")
public class Group implements Serializable{
	private static final long serialVersionUID = 7898832144327621719L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@ManyToMany
	@JoinTable(name = "group_role",
			joinColumns = @JoinColumn(name = "groups_id"),
			inverseJoinColumns = @JoinColumn(name = "roles_id"))
	private List<Role> roles = new ArrayList<>();
}
