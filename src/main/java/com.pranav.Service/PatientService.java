package com.pranav.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pranav.DAO.PatientDAO;
import com.pranav.DTO.ResponseStructure;
import com.pranav.Entity.Patient;

@Service
public class PatientService {
	@Autowired
	private PatientDAO patientDAO;

	public ResponseEntity<ResponseStructure<Patient>> addPatient(Patient patient) {
		Patient receivedPatient = patientDAO.savePatient(patient);
		ResponseStructure<Patient> rs = new ResponseStructure<Patient>();
		rs.setStatusCode(HttpStatus.CREATED.value());
		rs.setData(receivedPatient);
		rs.setMessage("Patient created Successfully");
		return new ResponseEntity<ResponseStructure<Patient>>(rs, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Patient>> getAppointment(int id) {
		Patient data = patientDAO.getPatient(id);
		ResponseStructure<Patient> rs = new ResponseStructure<Patient>();
		rs.setStatusCode(HttpStatus.FOUND.value());
		rs.setData(data);
		rs.setMessage("Patient found successfullly");
		return new ResponseEntity<ResponseStructure<Patient>>(rs, HttpStatus.FOUND);
	}
}

