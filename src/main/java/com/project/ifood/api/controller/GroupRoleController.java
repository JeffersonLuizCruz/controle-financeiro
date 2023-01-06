package com.project.ifood.api.controller;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.ifood.domain.model.ProfileGroup;
import com.project.ifood.domain.model.Role;
import com.project.ifood.domain.service.GroupRoleService;
import com.project.ifood.domain.service.GroupService;

import lombok.RequiredArgsConstructor;

@RestController @RequiredArgsConstructor
@RequestMapping("/groups/{groupId}/roles")
public class GroupRoleController {
	
	private final GroupRoleService groupRoleService;
	private final GroupService groupService;
	
	@GetMapping
	public ResponseEntity<Set<Role>> findByRoleAll(@PathVariable Long groupId){
		ProfileGroup group = groupService.checkIfGroupExists(groupId);
		return ResponseEntity.ok(group.getRoles());
	}
	
	@DeleteMapping("/{roleId}") @ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void disassociateRole(@PathVariable Long groupId, @PathVariable Long roleId){
		groupRoleService.disassociateRole(groupId, roleId);
	}
	
	@PutMapping("/{roleId}") @ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void associateRole(@PathVariable Long groupId, @PathVariable Long roleId){
		groupRoleService.associateRole(groupId, roleId);
	}

}
