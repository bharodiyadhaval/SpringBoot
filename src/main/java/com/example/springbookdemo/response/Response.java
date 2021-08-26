package com.example.springbookdemo.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {
    private int statusCode;
    private String statusMessage;
    private Object body;
}
