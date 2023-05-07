package com.inditex.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Component
@Data
@EqualsAndHashCode(callSuper = false)
public class InditexException extends RuntimeException {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
    private HttpStatus httpStatus;
    
	public InditexException() {}
	
	public InditexException(String msg, HttpStatus status)
    {
        super(msg);
        this.message = msg;
        this.httpStatus = status;
    }
}
