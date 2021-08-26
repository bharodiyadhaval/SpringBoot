package com.example.springbookdemo.exeption;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookExecption extends RuntimeException{
    private int statusCode;
    private String statusMessage;
}
