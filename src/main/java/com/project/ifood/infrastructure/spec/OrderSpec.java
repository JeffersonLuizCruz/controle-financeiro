package com.project.ifood.infrastructure.spec;

import java.util.ArrayList;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import com.project.ifood.domain.filter.OrderFilter;
import com.project.ifood.domain.model.Order;

public class OrderSpec {

	public static Specification<Order> filterOder(OrderFilter filter){
		return (root, query, cb) -> {
			if(Order.class.equals(query.getResultType())) {
				
				root.fetch("restaurant").fetch("kitchen");
				root.fetch("customer");
				root.fetch("paymentMethod");
			}
			
			var predicate = new ArrayList<Predicate>();
			
			if(filter.getId() != null) {
				predicate.add(cb.equal(root.get("id"), filter.getId()));
			}
			
			if(filter.getDateBegin() != null) {
				predicate.add(cb.greaterThanOrEqualTo(root.get("createAt"), filter.getDateBegin()));
			}
			
			if(filter.getDateEnd() != null) {
				predicate.add(cb.lessThanOrEqualTo(root.get("createAt"), filter.getDateEnd()));
			}
			
			return cb.and(predicate.toArray(new Predicate[0]));
		};
	}
	
	public static Specification<Order> createAtBetween(Long min, Long max) {
		return(root, query, cb) -> cb.between(root.get("id"), min, max);
	}
}
