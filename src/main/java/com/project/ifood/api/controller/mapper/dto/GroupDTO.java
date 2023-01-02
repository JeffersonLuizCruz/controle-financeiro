package com.project.ifood.api.controller.mapper.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

import com.project.ifood.domain.model.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class GroupDTO {
	
	@NotBlank(message = "O nome do group é obrigatório!")
	private String name;
	private List<Role> roles = new ArrayList<>();
}
