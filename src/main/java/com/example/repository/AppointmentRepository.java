package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.entity.Appointment;

@Repository
@Service
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}