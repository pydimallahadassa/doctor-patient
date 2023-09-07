package com.doctorservice.service;

import java.util.List;

import com.doctorservice.entity.Doctor;
import com.doctorservice.exception.DoctorExistsException;
import com.doctorservice.exception.DoctorNotFoundException;

public interface IDoctorService {
	
	Doctor addDoctor(Doctor doctor) throws DoctorExistsException;
	Doctor deleteDoctor(int drId) throws DoctorNotFoundException;
	Doctor updateDoctor(int drId, Doctor doc) throws DoctorNotFoundException;
	Doctor getDoctorById(int drId) throws DoctorNotFoundException;
	Doctor getDoctorByName(String drName) throws DoctorNotFoundException;
	Doctor getByChargesAndNoOfHrs(long charges, String noOfHrs) throws DoctorNotFoundException;
	List<Doctor> getAll();

}
