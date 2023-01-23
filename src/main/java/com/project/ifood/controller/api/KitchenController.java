package com.project.ifood.controller.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.ifood.controller.dto.request.KitchenDTO;
import com.project.ifood.controller.dto.response.KitchenResponseDTO;
import com.project.ifood.controller.mapper.KitchenMapper;
import com.project.ifood.domain.model.Kitchen;
import com.project.ifood.domain.repositoy.KitchenRepository;
import com.project.ifood.domain.service.KitchenService;

import lombok.RequiredArgsConstructor;

@RestController @RequiredArgsConstructor
@RequestMapping("/kitchens")
public class KitchenController {
	
	private final KitchenService kitchenService;
	private final KitchenMapper kitchenMapper;
	private final KitchenRepository kitchenRepository;
	

	@PostMapping
	public ResponseEntity<KitchenResponseDTO> save(@RequestBody KitchenDTO dto) {
		Kitchen modelKitchen = kitchenMapper.toModel(dto);
		Kitchen kitchenEntity = kitchenService.save(modelKitchen);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(kitchenMapper.toDTO(kitchenEntity));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<KitchenResponseDTO> update(@PathVariable Long id, @RequestBody KitchenDTO dto){
		Kitchen modelKitchen = kitchenMapper.toModel(dto);
		Kitchen kitchenEntity = kitchenService.update(id, modelKitchen);
		
		return ResponseEntity.ok(kitchenMapper.toDTO(kitchenEntity));
	}
	
	@GetMapping
	public ResponseEntity<Page<KitchenResponseDTO>> findAll(Pageable page) {
//		List<KitchenResponseDTO> listKichenDTO = kitchenRepository.findAll(page).getContent().stream()
//				.map(kitchen -> kitchenMapper.toDTO(kitchen)).collect(Collectors.toList());
		Page<Kitchen> pageListKitchen = kitchenRepository.findAll(page);
		
		List<KitchenResponseDTO> listKichenDTO = pageListKitchen.getContent().stream()
				.map(kitchen -> kitchenMapper.toDTO(kitchen)).collect(Collectors.toList());

		Page<KitchenResponseDTO> pageKitchenDTO = new PageImpl<>(listKichenDTO, page, pageListKitchen.getTotalElements() );
		return ResponseEntity.ok(pageKitchenDTO);
	}

	@GetMapping("/{id}")
	public ResponseEntity<KitchenResponseDTO> findById(@PathVariable Long id){
		Kitchen kitchenEntity = kitchenService.findById(id);
		
		return ResponseEntity.ok(kitchenMapper.toDTO(kitchenEntity));
	}
	
	@DeleteMapping("/{id}") @ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id){
		kitchenService.deleteById(id);
	}
}