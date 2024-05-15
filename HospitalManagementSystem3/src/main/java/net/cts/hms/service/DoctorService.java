package net.cts.hms.service;

import java.util.List;

import net.cts.hms.dto.Doctordto;

public interface DoctorService {
   
	Doctordto createDoctor(Doctordto doctordto);
	
	Doctordto getDoctorById(Long doctorId);
	
	List<Doctordto> getAllDoctors();
	
	Doctordto updateDoctor(Long doctorId, Doctordto updateDoctor);
	
	void deleteDoctor(Long doctorId);
}
