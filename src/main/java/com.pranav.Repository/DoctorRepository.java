package com.pranav.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pranav.Entity.Doctor;
public interface DoctorRepository extends JpaRepository<Doctor,Integer>{
  
  }
