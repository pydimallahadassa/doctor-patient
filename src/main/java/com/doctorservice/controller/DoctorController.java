package com.doctorservice.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctorservice.entity.Doctor;
import com.doctorservice.exception.DoctorExistsException;
import com.doctorservice.exception.DoctorNotFoundException;
import com.doctorservice.service.DoctorServiceImpl;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	DoctorServiceImpl docServ;
	
	private static Logger logger = LogManager.getLogger();
	
	@PostMapping("/add")
	ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doc) throws DoctorExistsException{
		logger.info("Sending request to add new doctor");
		Doctor newDoc = docServ.addDoctor(doc);
		logger.info("Added new doctor");
		return new ResponseEntity<>(newDoc, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{drId}")
	ResponseEntity<Doctor> deleteDoctor(@PathVariable int drId) throws DoctorNotFoundException{
		logger.info("Request to delete a doctor");
		Doctor deletedDoc = docServ.deleteDoctor(drId);
		logger.info("Successfully deleted a doctor");
		return new ResponseEntity<>(deletedDoc,HttpStatus.OK);
	}
	
	@PutMapping("/update/{drId}")
	ResponseEntity<Doctor> updateDoctor(@PathVariable int drId,@RequestBody Doctor doc) throws DoctorNotFoundException{
		logger.info("Request to update existing Doctor");
		Doctor updatedDoc = docServ.updateDoctor(drId, doc);
		logger.info("Successfully updated existing Doctor");
		return new ResponseEntity<>(updatedDoc, HttpStatus.OK);
	}
	
	@GetMapping("/get/{drId}")
	ResponseEntity<Doctor> getDoctorById(@PathVariable int drId) throws DoctorNotFoundException{
		logger.info("Request to view a Doctor by drId");
		Doctor doc = docServ.getDoctorById(drId);
		logger.info("Successfully viewed a Doctor by drId");
		return new ResponseEntity<>(doc,HttpStatus.OK);
	}
	
	@GetMapping("/getByName/{drName}")
	ResponseEntity<Doctor> getDoctorByName(@PathVariable String drName) throws DoctorNotFoundException{
		logger.info("Request to view a Doctor by drName");
		Doctor doc = docServ.getDoctorByName(drName);
		logger.info("Successfully viewed a Doctor by drName");
		return new ResponseEntity<>(doc,HttpStatus.OK);
	}
	
	@GetMapping("/get/{charges}/{noOfHrs}")
	ResponseEntity<Doctor> getByChargesAndNoOfHrs(@PathVariable long charges, @PathVariable String noOfHrs) throws DoctorNotFoundException{
		logger.info("Request to view a Doctor by charges and no. of hours");
		Doctor doc = docServ.getByChargesAndNoOfHrs(charges, noOfHrs);
		logger.info("Successfully viewed a Doctor by charges and no. of hours");
		return new ResponseEntity<>(doc,HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	ResponseEntity<List<Doctor>> getAll(){
		logger.info("Request to view all Doctors");
		List<Doctor> docs = docServ.getAll();
		logger.info("Successfully viewed all Doctors");
		return new ResponseEntity<>(docs,HttpStatus.OK);
	}
	
}
