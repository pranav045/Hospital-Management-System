package com.pranav.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pranav.DTO.ResponseStructure;
import com.pranav.Entity.Appointment;
import com.pranav.Service.AppointmentService;

@RestController
public class AppointmentController {
	@Autowired
	private AppointmentService appointmentService;

	@PostMapping("/saveAppointment")
	public ResponseEntity<ResponseStructure<Appointment>> saveAppointment(@RequestBody Appointment appointment) {
		return appointmentService.saveAppointment(appointment);
	}

	@GetMapping("/getAppointment/{id}")
	public ResponseEntity<ResponseStructure<Appointment>> getAppointment(@PathVariable int id) {
		return appointmentService.getAppointment(id);
	}

	@GetMapping("/getAllAppointments")
	public ResponseEntity<ResponseStructure<List<Appointment>>> getAllAppointments() {
		return appointmentService.getAllAppointments();
	}

	@DeleteMapping("/deleteAppointment/{id}")
	public ResponseEntity<ResponseStructure<Appointment>> deleteAppointment(@PathVariable int id) {
		return appointmentService.deleteAppointment(id);
	}

}
