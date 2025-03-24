package com.javaweb.controllerAdvice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.javaweb.CustomException.FieldRequiredException;
import com.javaweb.Model.ErrorResponseDTO;


@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<Object> handlerArithmeticException(ArithmeticException ex, WebRequest request){
		ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
		errorResponseDTO.setError(ex.getMessage());
		List<String> details = new ArrayList<String>();
		details.add("So nguyen lam sao chia duoc cho 0?");
		errorResponseDTO.setDetails(details);
		
		return new ResponseEntity<Object>(errorResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(FieldRequiredException.class)
	public ResponseEntity<Object> handlerFieldRequiredException(FieldRequiredException ex, WebRequest request){
		ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
		errorResponseDTO.setError(ex.getMessage());
		List<String> details = new ArrayList<String>();
		details.add("Check lại name hoặc numberofbasement đi!");
		errorResponseDTO.setDetails(details);
		
		return new ResponseEntity<Object>(errorResponseDTO, HttpStatus.BAD_GATEWAY);
	}
	
}
