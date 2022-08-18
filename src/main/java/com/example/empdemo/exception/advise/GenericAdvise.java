package com.example.empdemo.exception.advise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeType;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
@ControllerAdvice
public class GenericAdvise {
	@ExceptionHandler({
        MethodArgumentTypeMismatchException.class,
        TypeMismatchException.class
})
public ResponseEntity<Map<String, String>> handleException(TypeMismatchException e) {
    Map<String, String> errorResponse = new HashMap<>();

    errorResponse.put("message", e.getLocalizedMessage());
    errorResponse.put("status", HttpStatus.BAD_REQUEST.toString());
    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
}
	@ExceptionHandler({
        BindException.class,
        MethodArgumentNotValidException.class
})
public ResponseEntity<Map<String, Object>> handleException(BindException e) {
        
    List<String> errors = new ArrayList<>();
    e.getFieldErrors()
             .forEach(err -> errors.add(err.getField() + ": " + err.getDefaultMessage()));
    e.getGlobalErrors()
             .forEach(err -> errors.add(err.getObjectName() + ": " + err.getDefaultMessage()));

    Map<String, Object> errorResponse = new HashMap<>();
    errorResponse.put("error", errors);

    errorResponse.put("message", e.getLocalizedMessage());
    errorResponse.put("status", HttpStatus.BAD_REQUEST.toString());
    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
}
	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public ResponseEntity<Map<String, String>> handleException(
	        HttpMediaTypeNotSupportedException e) {

	    String provided = e.getContentType().toString();
	    List<String> supported = e.getSupportedMediaTypes().stream()
	            .map(MimeType::toString)
	            .collect(Collectors.toList());

	    String error = provided + " is not one of the supported media types (" +
	            String.join(", ", supported) + ")";

	    Map<String, String> errorResponse = new HashMap<>();
	    errorResponse.put("error", error);
	    errorResponse.put("message", e.getLocalizedMessage());
	    errorResponse.put("status", HttpStatus.UNSUPPORTED_MEDIA_TYPE.toString());
	    
	    return new ResponseEntity<>(errorResponse, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}
	 @ExceptionHandler(ConstraintViolationException.class)
	  ResponseEntity<Map<String, String>> employeeNotFoundHandler(ConstraintViolationException ex) {
	    Map<String, String> errorResponse = new HashMap<>();
	    errorResponse.put("message", ex.getLocalizedMessage());
	    errorResponse.put("status", HttpStatus.BAD_REQUEST.toString());
	    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	  }
}
