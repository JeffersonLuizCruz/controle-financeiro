package com.project.ifood.infrastructure.projection.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class DailySalesProjec {
	private LocalDateTime date;
	private Long totalSales;
	private BigDecimal totalInvoice;
}
