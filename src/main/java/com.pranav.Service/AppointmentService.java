package com.pranav.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pranav.DAO.AppointmentDAO;
import com.pranav.DTO.ResponseStructure;
import com.pranav.Entity.Appointment;
import com.pranav.Exception.EmptyException;
import com.pranav.Exception.IdDoesNotPresentException;

@Service
public class AppointmentService {
	@Autowired
	private AppointmentDAO appointmentDAO;

	public ResponseEntity<ResponseStructure<Appointment>> saveAppointment(Appointment appointment) {
		Appointment data = appointmentDAO.saveAppointment(appointment);
		ResponseStructure<Appointment> rs = new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.CREATED.value());
		rs.setData(data);
		rs.setMessage("Created Successfully");
		return new ResponseEntity<>(rs, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Appointment>> getAppointment(int id) {
		Appointment data = appointmentDAO.getAppointment(id);
		if (data != null) {
			ResponseStructure<Appointment> rs = new ResponseStructure<>();
			rs.setStatusCode(HttpStatus.OK.value());
			rs.setData(data);
			rs.setMessage("Appointment found successfully");
			return new ResponseEntity<>(rs, HttpStatus.OK);
		} else {
			throw new IdDoesNotPresentException("Id " + id + " not found");
		}
	}

	public ResponseEntity<ResponseStructure<List<Appointment>>> getAllAppointments() {
		List<Appointment> data = appointmentDAO.getAllAppointments();
		if (data != null) {
			ResponseStructure<List<Appointment>> rs = new ResponseStructure<List<Appointment>>();
			rs.setData(data);
			rs.setMessage("All appointments found successfully");
			rs.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Appointment>>>(rs, HttpStatus.FOUND);
		} else {
			throw new EmptyException("No appointments found");
		}
	}
}
