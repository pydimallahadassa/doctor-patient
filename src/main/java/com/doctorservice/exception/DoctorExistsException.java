package com.doctorservice.exception;

@SuppressWarnings("serial")
public class DoctorExistsException extends Exception {

	public DoctorExistsException() {
	
	}

	public DoctorExistsException(String msg) {
		super(msg);
	}

}
