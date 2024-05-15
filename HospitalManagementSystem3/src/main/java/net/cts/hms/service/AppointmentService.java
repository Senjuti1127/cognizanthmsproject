package net.cts.hms.service;

import java.util.List;

import net.cts.hms.dto.AppointmenDto;


public interface AppointmentService {
	AppointmenDto createAppointment(AppointmenDto appointmentDto);
	
	AppointmenDto getAppointmentById(Long appointmentId);
	
	List<AppointmenDto> getAllAppointments();

	AppointmenDto updateAppointment(Long appointmentId, AppointmenDto updatedAppointment);

	void deleteAppointment(Long appointmentId);
}
