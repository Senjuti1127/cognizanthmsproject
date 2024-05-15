package net.cts.hms.mapper;

import net.cts.hms.dto.Doctordto;
import net.cts.hms.entity.Doctor;

public class DoctorMapper {
	 
	
	public static Doctordto mapToDoctordto(Doctor doctor)
	{
		return new Doctordto(
				doctor.getId(),
				doctor.getFirstName(),
				doctor.getLastName(),
				doctor.getEmail(),
				doctor.getAppointment().getId()
				);
	}
	
	
	public static Doctor mapToDoctor(Doctordto doctordto)
	{
		Doctor doctor = new Doctor();
		doctor.setId(doctordto.getId());
		doctor.setFirstName(doctordto.getFirstName());
		doctor.setLastName(doctordto.getLastName());
		doctor.setEmail(doctordto.getEmail());
	
	   return doctor;
	}
}
