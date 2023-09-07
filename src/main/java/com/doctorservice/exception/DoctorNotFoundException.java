package com.doctorservice.exception;

@SuppressWarnings("serial")
public class DoctorNotFoundException extends Exception{
	
	public DoctorNotFoundException() {
		
	}
	
	public DoctorNotFoundException(String msg) {
		super(msg);
	}

}
