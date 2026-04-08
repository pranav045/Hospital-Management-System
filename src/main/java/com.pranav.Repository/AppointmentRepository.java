package com.pranav.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pranav.Entity.Appointment;
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

}
