package net.cts.hms.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import net.cts.hms.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Long>{
	
	

}
