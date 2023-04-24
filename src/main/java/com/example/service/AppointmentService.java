package com.example.service;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.example.entity.Appointment;
import com.example.repository.AppointmentRepository;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }
    
    public void save(Appointment product) {
    	appointmentRepository.save(product);
    }
    
    public Appointment updateAppointment(Appointment appointment, Long appointmentId)
    {
    	Appointment appt = appointmentRepository.findById(appointmentId).get();
 
        if ( Objects.nonNull(appt.getTitle()) ) {
        	appt.setTitle(appointment.getTitle());
        }
        if ( Objects.nonNull(appt.getCustomerName()) ) {
        	appt.setCustomerName(appointment.getCustomerName());
        }
        if ( Objects.nonNull(appt.getStartDate()) ) {
        	appt.setStartDate(appointment.getStartDate());
        }
        if ( Objects.nonNull(appt.getEndDate()) ) {
        	appt.setEndDate(appointment.getEndDate());
        }
        if ( Objects.nonNull(appt.getAssignee()) ) {
        	appt.setAssignee(appointment.getAssignee());
        }
        if ( Objects.nonNull(appt.getStatus()) ) {
        	appt.setStatus(appointment.getStatus());
        }
 
        return appointmentRepository.save(appt);
    }

    public void deleteById(Long id) {
        appointmentRepository.deleteById(id);
    }
}
