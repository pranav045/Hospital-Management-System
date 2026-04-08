package com.pranav.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pranav.Entity.Patient;
@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer>{
  
}
