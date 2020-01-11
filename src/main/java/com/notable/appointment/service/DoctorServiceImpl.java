package com.notable.appointment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.notable.appointment.exception.ResourceNotFoundException;
import com.notable.appointment.model.Appointment;
import com.notable.appointment.model.Doctor;
import com.notable.appointment.repository.DoctorRepository;

@Component("doctorservice")
public class DoctorServiceImpl implements DoctorService{
	
	@Autowired
    DoctorRepository doctorRepository;

	@Override
	public Optional<Doctor> findById(Long doctorId) {
		// TODO Auto-generated method stub
		return doctorRepository.findById(doctorId);
	}

	@Override
	public List<Doctor> findAll() {
		// TODO Auto-generated method stub
		return doctorRepository.findAll();
	}

	@Override
	public Doctor getById(Long doctorId) throws RuntimeException {
		// TODO Auto-generated method stub
		Doctor doctor = null;
		try {
			doctor = doctorRepository.findById(doctorId).orElseThrow(() -> new ResourceNotFoundException("Doctor not found"));
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doctor;
	}
	
	 

}
