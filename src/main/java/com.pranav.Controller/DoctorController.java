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
import com.pranav.Entity.Doctor;
import com.pranav.Service.DoctorService;

@RestController
public class DoctorController {
	@Autowired
	private DoctorService doctorService;

	@PostMapping("/saveDoctor")
	public ResponseEntity<ResponseStructure<Doctor>> saveDoctor(@RequestBody Doctor doctor) {
		return doctorService.saveDoctor(doctor);
	}

	@GetMapping("/getDoctor/{id}")
	public ResponseEntity<ResponseStructure<Doctor>> getDoctorById(@PathVariable int id) {
		return doctorService.getDoctor(id);
	}

	@GetMapping("/getAllDoctors")
	public ResponseEntity<ResponseStructure<List<Doctor>>> getAllDoctors() {
		return doctorService.getAllDoctors();
	}

	@DeleteMapping("/deleteDoctor/{id}")
	public ResponseEntity<ResponseStructure<Doctor>> deletePatient(@PathVariable int id) {
		return doctorService.deleteDoctor(id);
	}
}
