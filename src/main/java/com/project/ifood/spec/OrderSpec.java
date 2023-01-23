package com.project.ifood.spec;

import java.util.ArrayList;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import com.project.ifood.domain.model.Order;
import com.project.ifood.domain.repositoy.filter.FilterOrder;

public class OrderSpec {

	public static Specification<Order> filterOder(FilterOrder filter){
		return (root, query, builder) -> {
			
			var predicate = new ArrayList<Predicate>();
			
			if(filter.getId() != null) {
				predicate.add(builder.equal(root.get("id"), filter.getId()));
			}
			
			return builder.and(predicate.toArray(new Predicate[0]));
		};
	}
}
