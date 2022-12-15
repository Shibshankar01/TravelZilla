package com.travelzilla.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(RouteException.class)
	public ResponseEntity<MyError> GlobalExceptionHandler(RouteException cm,WebRequest req){
		
		MyError er=new MyError();
		er.setTimeStamp(LocalDateTime.now());
		er.setMessage(cm.getMessage());
		er.setDesc(req.getDescription(false));
		
		return new ResponseEntity<MyError>(er, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(BusException.class)
	public ResponseEntity<MyError> GlobalExceptionHandler(BusException cm,WebRequest req){
		
		MyError er=new MyError();
		er.setTimeStamp(LocalDateTime.now());
		er.setMessage(cm.getMessage());
		er.setDesc(req.getDescription(false));
		
		return new ResponseEntity<MyError>(er, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(TravelsException.class)
	public ResponseEntity<MyError> GlobalExceptionHandler(TravelsException cm,WebRequest req){
		
		MyError er=new MyError();
		er.setTimeStamp(LocalDateTime.now());
		er.setMessage(cm.getMessage());
		er.setDesc(req.getDescription(false));
		
		return new ResponseEntity<MyError>(er, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyError> ExceptionHandler(Exception cm,WebRequest req){
		
		MyError er=new MyError();
		er.setTimeStamp(LocalDateTime.now());
		er.setMessage(cm.getMessage());
		er.setDesc(req.getDescription(false));
		
		return new ResponseEntity<MyError>(er, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyError> ExceptionHandler(MethodArgumentNotValidException cm){
		
		MyError er=new MyError();
		er.setTimeStamp(LocalDateTime.now());
		er.setMessage("Validation error..!");
		er.setDesc(cm.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<MyError>(er, HttpStatus.BAD_REQUEST);
		
	}
	
	

}
