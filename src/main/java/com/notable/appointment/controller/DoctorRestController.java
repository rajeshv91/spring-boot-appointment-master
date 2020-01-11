package com.notable.appointment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.notable.appointment.model.Appointment;
import com.notable.appointment.model.Doctor;
import com.notable.appointment.service.DoctorService;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorRestController {
	
	 @Autowired
	    private DoctorService doctorService;
	 
	  public DoctorRestController() {
	    }

	    public DoctorRestController(DoctorService doctorService) {
	        this.doctorService = doctorService;
	    }
	    
	    /** GET request to return all appointments **/
	    @RequestMapping(path = "/", method = RequestMethod.GET)
	    List<Doctor> findAll() {
	        return doctorService.findAll();
	    }
	    
	    /** GET request to return specific appointments 
	     * @throws Exception **/
		@RequestMapping(path = "/{doctorID}", method = RequestMethod.GET)
		public Doctor findById(@PathVariable Long doctorId) throws Exception {
			return doctorService.getById(doctorId);
		}

}
