package com.project.ifood.controller.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ifood.infrastructure.projection.filter.DailySalesFilter;
import com.project.ifood.infrastructure.projection.model.DailySalesProjec;
import com.project.ifood.infrastructure.projection.service.DailySalesProjectionService;

import lombok.RequiredArgsConstructor;

@RestController @RequiredArgsConstructor
@RequestMapping("/statistics")
public class SalesStatisticsController {
	
	private final DailySalesProjectionService dailySalesProjectionService;
	
	@GetMapping("/daily-sales")
	public ResponseEntity<List<DailySalesProjec>> listDailySales(DailySalesFilter filter){
		return ResponseEntity.ok(dailySalesProjectionService.listProjection(filter));
	}

}
