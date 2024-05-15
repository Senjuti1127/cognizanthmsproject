package net.cts.hms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import net.cts.hms.dto.Doctordto;
import net.cts.hms.entity.Appointment;
import net.cts.hms.entity.Doctor;
import net.cts.hms.exception.ResourceNotFoundException;
import net.cts.hms.mapper.DoctorMapper;
import net.cts.hms.repository.AppointmentRepository;
import net.cts.hms.repository.DoctorRepository;
import net.cts.hms.service.DoctorService;


@Service

public class DoctorServiceImpl implements DoctorService  {

	public DoctorServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	public DoctorServiceImpl(DoctorRepository doctorRepository) {
	super();
	this.doctorRepository = doctorRepository;
}
	@Override
	public Doctordto createDoctor(Doctordto doctordto) {
		// TODO Auto-generated method stub
		Doctor doctor = DoctorMapper.mapToDoctor(doctordto);
		
		Appointment appointment = appointmentRepository.findById(doctordto.getAppointmentId())
		                     .orElseThrow(()-> 
		                     new ResourceNotFoundException("Appointment does not exists with id:"+doctordto.getAppointmentId()));
		
		doctor.setAppointment(appointment);
		
		
		Doctor saveDoctor = doctorRepository.save(doctor);
		
		return DoctorMapper.mapToDoctordto(saveDoctor);
	}
	@Override
	public Doctordto getDoctorById(Long doctorId) {
		// TODO Auto-generated method stub
		Doctor doctor= doctorRepository.findById(doctorId).orElseThrow(()-> 
		new ResourceNotFoundException("Doctor does not exist with given id:"+ doctorId));
		return DoctorMapper.mapToDoctordto(doctor);
	}
	@Override
	public List<Doctordto> getAllDoctors() {
		// TODO Auto-generated method stub
		List<Doctor> doctor = doctorRepository.findAll();
		return doctor.stream().map((doctors)->DoctorMapper.mapToDoctordto(doctors)).collect(Collectors.toList());
	}
	@Override
	public Doctordto updateDoctor(Long doctorId, Doctordto updateDoctor) {
		// TODO Auto-generated method stub
		Doctor doctor= doctorRepository.findById(doctorId).orElseThrow(()-> 
		new ResourceNotFoundException("Doctor does not exist with given id:"+ doctorId));
		
		doctor.setFirstName(updateDoctor.getFirstName());
		doctor.setLastName(updateDoctor.getLastName());
		doctor.setEmail(updateDoctor.getEmail());
		
		Appointment appointment = appointmentRepository.findById(updateDoctor.getAppointmentId())
                .orElseThrow(()-> 
                new ResourceNotFoundException("Appointment does not exists with id:"+updateDoctor.getAppointmentId()));

             doctor.setAppointment(appointment);

		
		Doctor updateDoctorObj = doctorRepository.save(doctor);
		
		return DoctorMapper.mapToDoctordto(updateDoctorObj);
	}
	@Override
	public void deleteDoctor(Long doctorId) {
		// TODO Auto-generated method stub
		Doctor doctor= doctorRepository.findById(doctorId).orElseThrow(()-> 
		new ResourceNotFoundException("Doctor does not exist with given id:"+ doctorId));
		
		doctorRepository.deleteById(doctorId);
	}	
}
