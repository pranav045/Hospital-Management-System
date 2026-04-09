package com.pranav.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pranav.Entity.Doctor;
import com.pranav.Repository.DoctorRepository;

@Repository
public class DoctorDAO {
	@Autowired
	private DoctorRepository doctorRepository;

	public Doctor saveDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	public Doctor getDoctor(int id) {
		return doctorRepository.findById(id).orElse(null);
	}

	public boolean deleteDoctor(int id) {
		if (doctorRepository.existsById(id)) {
			doctorRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}
