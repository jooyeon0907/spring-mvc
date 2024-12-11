package com.example.WebSample.dto;


import com.example.WebSample.exception.ErroCode;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor // 자동으로 생성자를 만들어줌 (Lombok 활용)
@Data // 자동으로 getter/setter 생성해줌 (Lombok 활용)
public class ErrorResponse {
	private ErroCode errorCode;
    private String message;
}


