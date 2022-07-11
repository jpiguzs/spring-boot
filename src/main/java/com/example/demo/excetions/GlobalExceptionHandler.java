package com.example.demo.excetions;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.dto.ErrosDeatails;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(RecourceNotFoundException.class)
	public ResponseEntity<ErrosDeatails> handleNotFoudnException(RecourceNotFoundException exception, WebRequest webRequest){
		ErrosDeatails errorsDetails = new ErrosDeatails(new Date(),exception.getMessage(),webRequest.getDescription(false));
		return new ResponseEntity<>(errorsDetails, HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
			Map<String, String>  errors = new HashMap<>();
			ex.getBindingResult().getAllErrors().forEach((error) ->{
				String fieldname = ((FieldError)error).getField();
				String msg = error.getDefaultMessage();
				errors.put(fieldname, msg);
			});
			
			return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);

		// If you want to throw apiError directly, uncomment this
	}
	
}
