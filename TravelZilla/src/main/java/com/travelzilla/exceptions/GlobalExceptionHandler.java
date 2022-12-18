package com.travelzilla.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BookingException.class)
	public ResponseEntity<MyErrorDetails> BookingExceptionHandler(BookingException be, WebRequest req) {

		MyErrorDetails myerr = new MyErrorDetails();
		myerr.setTimestamp(LocalDateTime.now());
		myerr.setMessage(be.getMessage());
		myerr.setDetails(req.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(myerr, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(PaymentException.class)
	public ResponseEntity<MyErrorDetails> PaymentExceptionHandler(PaymentException pe, WebRequest req) {

		MyErrorDetails myErrDetails = new MyErrorDetails();
		myErrDetails.setTimestamp(LocalDateTime.now());
		myErrDetails.setMessage(pe.getMessage());
		myErrDetails.setDetails(req.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(myErrDetails, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(SessionException.class)
	public ResponseEntity<MyErrorDetails> SessionExceptionHandler(SessionException se, WebRequest req) {

		MyErrorDetails er = new MyErrorDetails();
		er.setTimestamp(LocalDateTime.now());
		er.setMessage(se.getMessage());
		er.setDetails(req.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(er, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(RouteException.class)
	public ResponseEntity<MyErrorDetails> RouteExceptionHandler(RouteException cm, WebRequest req) {

		MyErrorDetails er = new MyErrorDetails();
		er.setTimestamp(LocalDateTime.now());
		er.setMessage(cm.getMessage());
		er.setDetails(req.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(er, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(BusException.class)
	public ResponseEntity<MyErrorDetails> BusExceptionHandler(BusException cm, WebRequest req) {

		MyErrorDetails er = new MyErrorDetails();
		er.setTimestamp(LocalDateTime.now());
		er.setMessage(cm.getMessage());
		er.setDetails(req.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(er, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(TravelsException.class)

	public ResponseEntity<MyErrorDetails> TravelsExceptionHandler(TravelsException cm, WebRequest req) {

		MyErrorDetails er = new MyErrorDetails();
		er.setTimestamp(LocalDateTime.now());
		er.setMessage(cm.getMessage());
		er.setDetails(req.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(er, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<MyErrorDetails> CustomerExceptionHandler(CustomerException ce, WebRequest web) {
		MyErrorDetails myerr = new MyErrorDetails();
		myerr.setTimestamp(LocalDateTime.now());
		myerr.setMessage(ce.getMessage());
		myerr.setDetails(web.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(myerr, HttpStatus.BAD_GATEWAY);
	}

	@ExceptionHandler(AdminException.class)
	public ResponseEntity<MyErrorDetails> AdminExceptionHandler(AdminException ae, WebRequest web) {
		MyErrorDetails myerr = new MyErrorDetails();
		myerr.setTimestamp(LocalDateTime.now());
		myerr.setMessage(ae.getMessage());
		myerr.setDetails(web.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(myerr, HttpStatus.BAD_GATEWAY);
	}

	@ExceptionHandler(ReportException.class)
	public ResponseEntity<MyErrorDetails> ReportExceptionHandler(ReportException ae, WebRequest web) {
		MyErrorDetails myerr = new MyErrorDetails();
		myerr.setTimestamp(LocalDateTime.now());
		myerr.setMessage(ae.getMessage());
		myerr.setDetails(web.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(myerr, HttpStatus.BAD_GATEWAY);
	}

	@ExceptionHandler(HotelException.class)
	public ResponseEntity<MyErrorDetails> HotelExceptionHandler(HotelException pException, WebRequest wRequest) {

		MyErrorDetails myErrDetails = new MyErrorDetails();
		myErrDetails.setTimestamp(LocalDateTime.now());
		myErrDetails.setMessage(pException.getMessage());
		myErrDetails.setDetails(wRequest.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(myErrDetails, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(PackageException.class)
	public ResponseEntity<MyErrorDetails> PackageExceptionHandler(PackageException pException, WebRequest wRequest) {

		MyErrorDetails myErrDetails = new MyErrorDetails();
		myErrDetails.setTimestamp(LocalDateTime.now());
		myErrDetails.setMessage(pException.getMessage());
		myErrDetails.setDetails(wRequest.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(myErrDetails, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> myAnyExpHandler(Exception anyException, WebRequest wRequest) {

		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(anyException.getMessage());
		err.setDetails(wRequest.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);

	}

	// to handle Not found exception
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> mynotFoundHandler(NoHandlerFoundException nfe, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), nfe.getMessage(), req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}

}
