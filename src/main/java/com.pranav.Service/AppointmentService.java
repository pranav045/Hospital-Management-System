package com.pranav.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pranav.DAO.AppointmentDAO;
import com.pranav.DTO.ResponseStructure;
import com.pranav.Entity.Appointment;

@Service
public class AppointmentService {
	@Autowired
	private AppointmentDAO appointmentDAO;

	public ResponseEntity<ResponseStructure<Appointment>> saveAppointment(Appointment appointment) {
		Appointment data = appointmentDAO.saveAppointment(appointment);
		ResponseStructure<Appointment> rs = new ResponseStructure<Appointment>();
		rs.setStatusCode(HttpStatus.CREATED.value());
		rs.setData(data);
		rs.setMessage("Created Successfully");
		return new ResponseEntity<ResponseStructure<Appointment>>(rs, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Appointment>> getAppointment(int id) {
		Appointment data = appointmentDAO.getAppointment(id);
		ResponseStructure<Appointment> rs = new ResponseStructure<Appointment>();
		rs.setStatusCode(HttpStatus.FOUND.value());
		rs.setData(data);
		rs.setMessage("Appointment found successfullly");
		return new ResponseEntity<ResponseStructure<Appointment>>(rs, HttpStatus.FOUND);
	}
}
