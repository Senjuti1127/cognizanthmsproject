package net.cts.hms.service.impl;

import java.util.List;


import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.cts.hms.dto.AppointmenDto;

import net.cts.hms.entity.Appointment;

import net.cts.hms.exception.ResourceNotFoundException;
import net.cts.hms.mapper.AppointmentMapper;

import net.cts.hms.repository.AppointmentRepository;
import net.cts.hms.service.AppointmentService;


@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	
	public AppointmentServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
 @Autowired
	private AppointmentRepository appointmentRepository;
 

	@Override
	public AppointmenDto createAppointment(AppointmenDto appointmentDto) {
		// TODO Auto-generated method stub
		Appointment appointment = AppointmentMapper.mapToAppointment(appointmentDto);
		Appointment saveAppointment = appointmentRepository.save(appointment);
		
		return AppointmentMapper.mapToAppointmentDto(saveAppointment);
	}


	@Override
	public AppointmenDto getAppointmentById(Long appointmentId) {
		// TODO Auto-generated method stub
		Appointment appointment= appointmentRepository.findById(appointmentId).orElseThrow(()-> 
		new ResourceNotFoundException("Patient does not exist with given id:"+ appointmentId));
		return AppointmentMapper.mapToAppointmentDto(appointment);
	}


	@Override
	public List<AppointmenDto> getAllAppointments() {
		// TODO Auto-generated method stub
		List<Appointment> appointment = appointmentRepository.findAll();
		return appointment.stream().map((appointments)->AppointmentMapper.mapToAppointmentDto(appointments)).collect(Collectors.toList());
	}

	@Override
	public AppointmenDto updateAppointment(Long appointmentId, AppointmenDto updatedAppointment) {
		// TODO Auto-generated method stub
		Appointment appointment= appointmentRepository.findById(appointmentId).orElseThrow(()-> 
		new ResourceNotFoundException("Patient does not exist with given id:"+ appointmentId));
		
		appointment.setPatient_fName(updatedAppointment.getPatient_fName());
		appointment.setPatient_lName(updatedAppointment.getPatient_lName());
		appointment.setIllness(updatedAppointment.getIllness());
		
		Appointment savedAppointment = appointmentRepository.save(appointment);
		
		return AppointmentMapper.mapToAppointmentDto(savedAppointment);
	}
	
	@Override
	public void deleteAppointment(Long appointmentId) {
		// TODO Auto-generated method stub
		Appointment appointment= appointmentRepository.findById(appointmentId).orElseThrow(()-> 
		new ResourceNotFoundException("Patient does not exist with given id:"+ appointmentId));
		
		appointmentRepository.deleteById(appointmentId);

	}

}
