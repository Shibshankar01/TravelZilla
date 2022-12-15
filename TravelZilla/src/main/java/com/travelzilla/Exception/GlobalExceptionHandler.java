package com.travelzilla.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.travelzilla.exceptions.MyErrorDetails;
import com.travelzilla.exceptions.RouteException;
import com.travelzilla.exceptions.TravelsException;

@ControllerAdvice
public class GlobalExceptionHandler {

	

	@ExceptionHandler(RouteException.class)
	public ResponseEntity<MyErrorDetails> GlobalExceptionHandler(RouteException cm,WebRequest req){
		
		MyErrorDetails er=new MyErrorDetails();
		er.setTimestamp(LocalDateTime.now());
		er.setMessage(cm.getMessage());
		er.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(er, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(BusException.class)
	public ResponseEntity<MyErrorDetails> GlobalExceptionHandler(BusException cm,WebRequest req){
		
		MyErrorDetails er=new MyErrorDetails();
		er.setTimestamp(LocalDateTime.now());
		er.setMessage(cm.getMessage());
		er.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(er, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(TravelsException.class)
	public ResponseEntity<MyErrorDetails> GlobalExceptionHandler(TravelsException cm,WebRequest req){
		
		MyErrorDetails er=new MyErrorDetails();
		er.setTimestamp(LocalDateTime.now());
		er.setMessage(cm.getMessage());
		er.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(er, HttpStatus.BAD_REQUEST);
		
	}
	public ResponseEntity<MyErrorDetails> ExceptionHandler(Exception cm,WebRequest req){
		
		MyErrorDetails er=new MyErrorDetails();
		er.setTimestamp(LocalDateTime.now());
		er.setMessage(cm.getMessage());
		er.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(er, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> ExceptionHandler(MethodArgumentNotValidException cm){
		
		MyErrorDetails er=new MyErrorDetails();
		er.setTimestamp(LocalDateTime.now());
		er.setMessage("Validation error..!");
		er.setDetails(cm.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<MyErrorDetails>(er, HttpStatus.BAD_REQUEST);
		
	}
	
	

}
