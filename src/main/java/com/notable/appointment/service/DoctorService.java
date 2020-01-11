package com.notable.appointment.service;

import java.util.List;
import java.util.Optional;

import com.notable.appointment.model.Doctor;

public interface DoctorService {

	Optional<Doctor> findById(Long doctorId);
	 List<Doctor> findAll();
	 public Doctor getById(Long doctorId) throws Exception;
}
