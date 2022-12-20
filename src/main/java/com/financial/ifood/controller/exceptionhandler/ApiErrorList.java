package com.financial.ifood.controller.exceptionhandler;

import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@Getter @Setter
public class ApiErrorList implements Serializable {

    private String message;
    private String field;
    private Object parameter;
}
