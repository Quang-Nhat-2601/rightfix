package com.app.rightfix.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Response {
    private int status;
    private String message;
    private Object data;

}
