package com.example.LibraryMgmt.exception;

public class RecordNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1454647567345L;

	public RecordNotFoundException(String exception) {
		super(exception);
	}

	public RecordNotFoundException(Exception exception) {
		super(exception);
	}
}
