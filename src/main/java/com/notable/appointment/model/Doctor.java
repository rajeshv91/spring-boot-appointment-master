package com.notable.appointment.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;


@Data
@Entity
public class Doctor {
	private @Id @GeneratedValue Long id;	
	private String firstName;
	private String lastName;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Appointment> appointment=null;
	

    public  Doctor() {
		// TODO Auto-generated constructor stub
	}

   
	public Doctor(String firstName, String lastName, List<Appointment> appointment) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.appointment=appointment;
	}
	public Doctor(String firstName, String lastName) {
		this.firstName=firstName;
		this.lastName=lastName;
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public List<Appointment> getAppointment() {
		return appointment;
	}
	public void setAppointment(List<Appointment> appointment) {
		this.appointment = appointment;
	}

}
