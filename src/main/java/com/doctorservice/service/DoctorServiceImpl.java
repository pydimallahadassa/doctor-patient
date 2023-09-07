package com.doctorservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctorservice.entity.Doctor;
import com.doctorservice.exception.DoctorExistsException;
import com.doctorservice.exception.DoctorNotFoundException;
import com.doctorservice.repository.IDoctorRepository;

@Service
public class DoctorServiceImpl implements IDoctorService{
	
	@Autowired
	IDoctorRepository docRepo;
	
	DoctorNotFoundException ex = new DoctorNotFoundException("Task not found");

	@Override
	public Doctor addDoctor(Doctor doctor) throws DoctorExistsException {
		Optional<Doctor> d1 = docRepo.findByDrName(doctor.getDrName());
		if(d1.isPresent()) {
			throw new DoctorExistsException("Doctor already exists with name: "+doctor.getDrName());
		} else {
			return docRepo.save(doctor);
		}
	}

	@Override
	public Doctor deleteDoctor(int drId) throws DoctorNotFoundException {
		Optional<Doctor> docOpt = docRepo.findById(drId);
		if(docOpt.isPresent()) {
			Doctor d1 = docOpt.get();
			docRepo.deleteById(drId);
			return d1;
		}else {
			throw new DoctorNotFoundException("Doctor not found with given id:"+drId);
		}
	}

	@Override
	public Doctor updateDoctor(int drId, Doctor doc) throws DoctorNotFoundException {
		Optional<Doctor> d1 = docRepo.findById(drId);
		if(d1.isPresent()) {
			Doctor updatedDoc = d1.get();
			updatedDoc.setDrName(doc.getDrName());
			updatedDoc.setCharges(doc.getCharges());
			updatedDoc.setNoOfHrs(doc.getNoOfHrs());
			docRepo.save(updatedDoc);
			return updatedDoc;
		} else {
			throw ex;
		}
	}

	@Override
	public Doctor getDoctorById(int drId) throws DoctorNotFoundException {
		Optional<Doctor> d1=docRepo.findById(drId);
		if(d1.isPresent()) {
			return d1.get();
		}else {
			throw ex;
		}
	}

	@Override
	public Doctor getDoctorByName(String drName) throws DoctorNotFoundException {
		Optional<Doctor> d1=docRepo.findByDrName(drName);
		if(d1.isPresent()) {
			return d1.get();
		}else {
			throw ex;
		}
	}

	@Override
	public Doctor getByChargesAndNoOfHrs(long charges, String noOfHrs) throws DoctorNotFoundException {
		Optional<Doctor> d1=docRepo.findByChargesAndNoOfHrs(charges, noOfHrs);
		if(d1.isPresent()) {
			return d1.get();
		}else {
			throw ex;
		}
		
	}

	@Override
	public List<Doctor> getAll() {
		return docRepo.findAll();
	}

}
