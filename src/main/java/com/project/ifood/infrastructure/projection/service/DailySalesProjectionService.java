package com.project.ifood.infrastructure.projection.service;

import java.util.List;

import com.project.ifood.infrastructure.projection.filter.DailySalesFilter;
import com.project.ifood.infrastructure.projection.model.DailySalesProjec;

public interface DailySalesProjectionService {

	List<DailySalesProjec> listProjection(DailySalesFilter filter);
}
