package com.pranav.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pranav.DAO.PatientDAO;
import com.pranav.DTO.ResponseStructure;
import com.pranav.Entity.Patient;
import com.pranav.Exception.EmptyException;
import com.pranav.Exception.IdDoesNotPresentException;

@Service
public class PatientService {
	@Autowired
	private PatientDAO patientDAO;

	public ResponseEntity<ResponseStructure<Patient>> savePatient(Patient patient) {
		Patient receivedPatient = patientDAO.savePatient(patient);
		ResponseStructure<Patient> rs = new ResponseStructure<Patient>();
		rs.setStatusCode(HttpStatus.CREATED.value());
		rs.setData(receivedPatient);
		rs.setMessage("Patient created Successfully");
		return new ResponseEntity<ResponseStructure<Patient>>(rs, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Patient>> getPatient(int id) {
		Patient data = patientDAO.getPatient(id);
		if (data != null) {
			ResponseStructure<Patient> rs = new ResponseStructure<Patient>();
			rs.setStatusCode(HttpStatus.FOUND.value());
			rs.setData(data);
			rs.setMessage("Patient found successfullly");
			return new ResponseEntity<ResponseStructure<Patient>>(rs, HttpStatus.FOUND);
		} else {
			throw new IdDoesNotPresentException("Id " + id + " does not found");
		}
	}

	public ResponseEntity<ResponseStructure<List<Patient>>> getAllPatients() {
		List<Patient> data = patientDAO.getAllPatients();
		if (data != null) {
			ResponseStructure<List<Patient>> rs = new ResponseStructure<List<Patient>>();
			rs.setData(data);
			rs.setMessage("All appointments found successfully");
			rs.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Patient>>>(rs, HttpStatus.FOUND);
		} else {
			throw new EmptyException("No Patients found");
		}
	}

	public ResponseEntity<ResponseStructure<Patient>> deletePatient(int id) {
		Patient data = patientDAO.getPatient(id);
		if (data != null) {
			ResponseStructure<Patient> rs = new ResponseStructure<Patient>();
			patientDAO.deletePatient(id);
			rs.setData(null);
			rs.setMessage("Patient having id " + id + " deleted successfully");
			rs.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Patient>>(rs, HttpStatus.ACCEPTED);
		} else {
			throw new IdDoesNotPresentException("Patient id " + id + " not found");
		}
	}
}
