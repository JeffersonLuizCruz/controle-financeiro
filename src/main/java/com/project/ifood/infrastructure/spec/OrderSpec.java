package com.project.ifood.infrastructure.spec;

import java.util.ArrayList;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import com.project.ifood.domain.filter.OrderFilter;
import com.project.ifood.domain.model.Order;

public class OrderSpec {

	public static Specification<Order> filterOder(OrderFilter filter){
		return (root, query, builder) -> {
			if(Order.class.equals(query.getResultType())) {
				
				root.fetch("restaurant").fetch("kitchen");
				root.fetch("customer");
				root.fetch("paymentMethod");
			}
			
			var predicate = new ArrayList<Predicate>();
			
			if(filter.getId() != null) {
				predicate.add(builder.equal(root.get("id"), filter.getId()));
			}
			
			if(filter.getDateBegin() != null) {
				predicate.add(builder.greaterThanOrEqualTo(root.get("createAt"), filter.getDateBegin()));
			}
			
			if(filter.getDateEnd() != null) {
				predicate.add(builder.lessThanOrEqualTo(root.get("createAt"), filter.getDateEnd()));
			}
			
			return builder.and(predicate.toArray(new Predicate[0]));
		};
	}
}
