package com.pranav.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pranav.Entity.Patient;
import com.pranav.Repository.PatientRepository;

@Repository
public class PatientDAO {
	@Autowired
	private PatientRepository patientRepository;

	public Patient savePatient(Patient patient) {
		return patientRepository.save(patient);
	}

	public Patient getPatient(int id) {
		return patientRepository.findById(id).orElse(null);
	}

	public boolean deletePatient(int id) {
		if (patientRepository.existsById(id)) {
			patientRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}
