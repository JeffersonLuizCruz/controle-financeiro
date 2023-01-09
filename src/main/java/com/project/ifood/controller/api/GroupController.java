package com.project.ifood.controller.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ifood.controller.dto.GroupDTO;
import com.project.ifood.controller.mapper.GroupMapper;
import com.project.ifood.domain.model.Group;
import com.project.ifood.domain.service.GroupService;

import lombok.RequiredArgsConstructor;

@RestController @RequiredArgsConstructor
@RequestMapping("/groups")
public class GroupController {
	
	private final GroupService groupService;
	private final GroupMapper groupMapper;
	
	@PostMapping
	public ResponseEntity<Group> save(@RequestBody @Valid GroupDTO dto){
		Group group = groupMapper.toModel(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(groupService.save(group));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Group> update(@PathVariable Long id, @Valid @RequestBody GroupDTO dto){
		Group group = groupMapper.toModel(dto);
		return ResponseEntity.ok(groupService.update(id, group));
	}
	
	@GetMapping
	public ResponseEntity<List<Group>> findAll(){
		return ResponseEntity.ok(groupService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Group> findById(@PathVariable Long id){
		return ResponseEntity.ok(groupService.findById(id));
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		groupService.deleteById(id);
	}
}
