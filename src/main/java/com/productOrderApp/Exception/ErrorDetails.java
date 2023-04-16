package com.productOrderApp.Exception;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class ErrorDetails {
	
	private String message;
	
	private String details;
	
	private LocalDateTime timeStamp;
}
