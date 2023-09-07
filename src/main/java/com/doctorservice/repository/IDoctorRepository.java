package com.doctorservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doctorservice.entity.Doctor;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {

	Optional<Doctor> findByDrName(String drName);

	Optional<Doctor> findByCharges(long charges);

	Optional<Doctor> findByChargesAndNoOfHrs(long charges, String noOfHrs);

}
