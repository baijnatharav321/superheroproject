package com.mindtree.superheroproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mindtree.superheroproject.entitydto.ExceptionDto;
import com.mindtree.superheroproject.exception.ServiceException;

@RestControllerAdvice(assignableTypes= {Comiccontroller.class,})
public class ControllerException {
	

	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<ExceptionDto> serviceExceptionHandler(Exception e, Throwable cause){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDto(e.getMessage()));
	}

}
