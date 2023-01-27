package com.project.ifood.infrastructure.projection.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.ifood.infrastructure.projection.filter.DailySalesFilter;
import com.project.ifood.infrastructure.projection.model.DailySalesProjec;
import com.project.ifood.infrastructure.projection.service.DailySalesProjectionService;

@Service
public class DailySalesProjectionServiceImpl implements DailySalesProjectionService{

	@Override
	public List<DailySalesProjec> listProjection(DailySalesFilter filter) {
		// TODO - falta implementar consulta de projeção
		return null;
	}

}
