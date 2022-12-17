package com.financial.ifood.controller.exceptionhandler;

import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@Getter @Setter
public class ApiErrorList implements Serializable {

    private final String message;
    private final String field;
    private final Object parameter;
}
