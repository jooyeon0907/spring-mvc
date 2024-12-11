package com.example.WebSample.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class WebSampleException extends RuntimeException {
	private ErroCode errorCode;
	private String message;
}
