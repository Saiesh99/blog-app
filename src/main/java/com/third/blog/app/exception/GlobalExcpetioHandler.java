package com.third.blog.app.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.third.blog.app.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExcpetioHandler {

	@ExceptionHandler(ResourceNotFoundException.class)	
	public ResponseEntity<ApiResponse> resourceNotFoundException(ResourceNotFoundException e){
		String message = e.getMessage();
		ApiResponse apiResponse = new ApiResponse(message,false);
		return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> methodArgumentNotValidException(MethodArgumentNotValidException e){
		Map<String,String> map = new HashMap<>();
		e.getBindingResult().getAllErrors().forEach(error->{
			String fieldName = ((FieldError)error).getField();
			String message= error.getDefaultMessage();
			map.put(fieldName, message);
		});
		return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
	} 	
}
