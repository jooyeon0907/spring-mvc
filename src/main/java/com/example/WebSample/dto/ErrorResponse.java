package com.example.WebSample.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor // 자동으로 생성자를 만들어줌 (Lombok 활용)
@Data // 자동으로 getter/setter 생성해줌 (Lombok 활용)
public class ErrorResponse {
    private String errorCode;
    private String message;
}


