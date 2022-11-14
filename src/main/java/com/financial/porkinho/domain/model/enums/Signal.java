package com.financial.porkinho.domain.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Signal {

	INSTITUTION("C"), WORLD_WORK("O"), SPENT("G");
	
	private String description;
}
