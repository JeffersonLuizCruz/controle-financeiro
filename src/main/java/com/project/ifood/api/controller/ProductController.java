package com.project.ifood.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ifood.api.controller.mapper.ProductMapper;
import com.project.ifood.domain.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController @RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

	private final ProductService productService;
	private final ProductMapper roductMapper;

	//TODO
	
}
