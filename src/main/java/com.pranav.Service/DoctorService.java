package com.pranav.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pranav.DAO.DoctorDAO;
import com.pranav.DTO.ResponseStructure;
import com.pranav.Entity.Doctor;

@Service
public class DoctorService {
	@Autowired
	private DoctorDAO doctorDAO;

	public ResponseEntity<ResponseStructure<Doctor>> saveDoctor(Doctor doctor) {
		Doctor receivedDoctor = doctorDAO.saveDoctor(doctor);
		ResponseStructure<Doctor> rs = new ResponseStructure<Doctor>();
		rs.setStatusCode(HttpStatus.CREATED.value());
		rs.setData(receivedDoctor);
		rs.setMessage("Successfully saved");
		return new ResponseEntity<ResponseStructure<Doctor>>(rs, HttpStatus.CREATED);
	}
}
