package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Appointment;
import com.example.repository.AppointmentRepository;
import com.example.service.AppointmentService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000/")
public class AppointmentController {
	
  @Autowired
  private AppointmentRepository appointmentRepository;
  
  private final AppointmentService appointmentService;

  public AppointmentController(AppointmentService appointmentService) {
      this.appointmentService = appointmentService;
  }

  @PostMapping(path="/addappointment") 
  public @ResponseBody String addNewAppointment (@RequestParam String title
      , @RequestParam String cName, @RequestParam String startDate
      , @RequestParam String endDate, @RequestParam String assignee
      , @RequestParam String status) {

	Appointment n = new Appointment();
    n.setTitle(title);
    n.setCustomerName(cName);
    n.setStartDate(startDate);
    n.setEndDate(endDate);
    n.setAssignee(assignee);
    n.setStatus(status);
    appointmentRepository.save(n);
    return "Saved";
  }

  @GetMapping("/appointments")
  public @ResponseBody Iterable<Appointment> getAllAppointments() {
    return appointmentRepository.findAll();
  }
  
  @PutMapping("/appointments/{id}")
  public Appointment updateDepartment(@RequestBody Appointment appointment,
                   @PathVariable("id") Long appointmentId)
  {
      return appointmentService.updateAppointment(appointment, appointmentId);
  }

  @DeleteMapping("/appointments/{id}")
  public void deleteById(@PathVariable Long id) {
      appointmentService.deleteById(id);
  }
}