package com.notable.appointment.repository;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.notable.appointment.model.Appointment;
import com.notable.appointment.model.Doctor;
import com.notable.appointment.service.DoctorService;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;

@Configuration
@Slf4j
public class LoadDataRepository {

    static final private Logger logger = LoggerFactory.getLogger(LoadDataRepository.class);
    
    @Autowired
    private DoctorService doctorService;
    
    @Bean
    CommandLineRunner initDatabase(DoctorRepository doctorRepository) {
        return args -> {
           
            
        };
    }

    @Bean
    CommandLineRunner initDatabase(AppointmentRepository appointmentRepository, DoctorRepository doctorRepository) {
        return args -> {
        	 logger.info("Preloading " + doctorRepository.save(new Doctor("Ändres","Marcus")));
             logger.info("Preloading " + doctorRepository.save(new Doctor("Jack","Sparrow")));
            logger.info("Preloading " + appointmentRepository.save(new Appointment(LocalDate.of(2019, 2, 3), Time.valueOf("11:00:00"),  doctorService.getById((long) 1))));
            logger.info("Preloading " + appointmentRepository.save(new Appointment(LocalDate.of(2019, 2, 15), Time.valueOf("14:00:00"),  doctorService.getById((long) 1))));
            logger.info("Preloading " + appointmentRepository.save(new Appointment(LocalDate.of(2019, 1, 10), Time.valueOf("08:00:00"), doctorService.getById((long) 1))));
            logger.info("Preloading " + appointmentRepository.save(new Appointment(LocalDate.of(2019, 1, 23), Time.valueOf("18:00:00"), doctorService.getById((long) 1))));
        };
    }
}
