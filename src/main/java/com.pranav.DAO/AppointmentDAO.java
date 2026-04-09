package com.pranav.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pranav.Entity.Appointment;
import com.pranav.Repository.AppointmentRepository;

@Repository
public class AppointmentDAO {
	@Autowired
	private AppointmentRepository appointmentRepository;

	public Appointment saveAppointment(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}

	public Appointment getAppointment(int id) {
		return appointmentRepository.findById(id).orElse(null);
	}

	public boolean deleteAppointment(int id) {
		if (appointmentRepository.existsById(id)) {
			appointmentRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}
