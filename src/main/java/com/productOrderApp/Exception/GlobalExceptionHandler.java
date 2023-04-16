package com.productOrderApp.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ProductException.class)
	public ResponseEntity<ErrorDetails> productExceptionHandler(ProductException pe, WebRequest req){
		ErrorDetails ed = new ErrorDetails();
		ed.setMessage(pe.getMessage());
		ed.setDetails(req.getDescription(false));
		ed.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetails>(ed,HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(SalesOrderException.class)
	public ResponseEntity<ErrorDetails> salesOrderExceptionHandler(SalesOrderException pe, WebRequest req){
		ErrorDetails ed = new ErrorDetails();
		ed.setMessage(pe.getMessage());
		ed.setDetails(req.getDescription(false));
		ed.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetails>(ed,HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> validationExceptionHandler(MethodArgumentNotValidException  pe, WebRequest req){
		ErrorDetails ed = new ErrorDetails();
		ed.setMessage(pe.getFieldError().getDefaultMessage());
		ed.setDetails(req.getDescription(false));
		ed.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetails>(ed,HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> allExceptionHandler(Exception pe, WebRequest req){
		ErrorDetails ed = new ErrorDetails();
		ed.setMessage(pe.getMessage());
		ed.setDetails(req.getDescription(false));
		ed.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetails>(ed,HttpStatus.BAD_REQUEST);
	}
}
