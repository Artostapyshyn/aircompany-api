package com.artostapyshyn.aircompany.exception.handler;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Builder
@Getter
public class ApiError {
    private HttpStatus status;
    private String message;
}
