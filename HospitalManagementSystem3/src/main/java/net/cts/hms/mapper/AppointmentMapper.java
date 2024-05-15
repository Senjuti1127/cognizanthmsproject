package net.cts.hms.mapper;

import net.cts.hms.dto.AppointmenDto;

import net.cts.hms.entity.Appointment;

public class AppointmentMapper {
	 
	//convert appointment jpa entity into appointment dto
	public static AppointmenDto mapToAppointmentDto(Appointment appointment)
	{
		return new AppointmenDto(
				appointment.getId(),
				appointment.getPatient_fName(),
				appointment.getPatient_lName(),
				appointment.getIllness()
				);
	}
	
	//convert appointment dto entity into appointment jpa
	public static Appointment mapToAppointment(AppointmenDto appointmentDto)
	{
		return new Appointment(
				appointmentDto.getId(),
				appointmentDto.getPatient_fName(),
				appointmentDto.getPatient_lName(),
				appointmentDto.getIllness()
				);
	}
}