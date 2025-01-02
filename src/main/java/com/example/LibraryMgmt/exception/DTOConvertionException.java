package com.example.LibraryMgmt.exception;

public class DTOConvertionException extends RuntimeException {

	public DTOConvertionException(String message) {
	        super(message);
	    }

	public DTOConvertionException(String message, Throwable cause) {
	        super(message, cause);
	    }

}
