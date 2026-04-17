package com.pranav.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pranav.DTO.ResponseStructure;
import com.pranav.Entity.Patient;
import com.pranav.Service.PatientService;

@RestController
public class PatientController {
	@Autowired
	private PatientService patientService;

	@PostMapping("/savePatient")
	public ResponseEntity<ResponseStructure<Patient>> savePatient(@RequestBody Patient patient) {
		return patientService.savePatient(patient);
	}

	@GetMapping("/getPatient/{id}")
	public ResponseEntity<ResponseStructure<Patient>> getPatient(@PathVariable int id) {
		return patientService.getPatient(id);
	}
}


