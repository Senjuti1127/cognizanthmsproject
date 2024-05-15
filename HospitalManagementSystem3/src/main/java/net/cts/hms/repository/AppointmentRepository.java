package net.cts.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.cts.hms.entity.Appointment;



public interface AppointmentRepository extends JpaRepository<Appointment,Long>{
	
	

}

