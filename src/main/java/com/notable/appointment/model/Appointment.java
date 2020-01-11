package com.notable.appointment.model;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Appointment {

    private @Id @GeneratedValue Long id;
    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());
    private LocalDate appointmentDate;
    private Time appointmentStartTime;
    
    @OneToOne(targetEntity =Doctor.class )
	private Doctor doctorId;
    
    private AppointmentStatus status = AppointmentStatus.NewPatient;
    

    public Appointment() {

    }

    public Appointment(Timestamp createdAt, LocalDate appointmentDate, Time appointmentStartTime, Doctor nameOfDoctor, AppointmentStatus status) {
        this.createdAt = createdAt;
        this.appointmentDate = appointmentDate;
        this.appointmentStartTime = appointmentStartTime;
        
        this.doctorId = nameOfDoctor;
        this.status = status;
       
    }

    public Appointment(LocalDate appointmentDate, Time appointmentStartTime, Doctor optional) {
        this.appointmentDate = appointmentDate;
        this.appointmentStartTime = appointmentStartTime;
        
        this.doctorId = optional;
        
    }

    public Appointment(LocalDate appointmentDate, Doctor nameOfDoctor) {
        this.appointmentDate = appointmentDate;
        this.doctorId = nameOfDoctor;
       
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Time getAppointmentStartTime() {
        return appointmentStartTime;
    }

    public void setAppointmentStartTime(Time appointmentStartTime) {
        this.appointmentStartTime = appointmentStartTime;
    }

    

    public Doctor getNameOfDoctor() {
        return doctorId;
    }

    public void setNameOfDoctor(Doctor nameOfDoctor) {
        this.doctorId = nameOfDoctor;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

 
}
