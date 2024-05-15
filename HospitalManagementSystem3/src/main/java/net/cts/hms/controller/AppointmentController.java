package net.cts.hms.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.cts.hms.dto.AppointmenDto;
import net.cts.hms.service.AppointmentService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	
	public AppointmentController(AppointmentService appointmentService ) {
		super();
		// TODO Auto-generated constructor stub
		this.appointmentService=appointmentService;
	}
	
	//Build ADD appointment REST API
	
	public AppointmentController() {
		super();
		// TODO Auto-generated constructor stub
	}
	//@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<AppointmenDto> createAppointment(@RequestBody AppointmenDto appointmentDto)
	{
		AppointmenDto saveAppointment = appointmentService.createAppointment(appointmentDto);
		return new ResponseEntity<>(saveAppointment, HttpStatus.CREATED);
	}
	
	//Build Get Appointment REST API
	    //@PreAuthorize("hasAnyRole('ADMIN','USER')")
		@GetMapping("{id}")
		public ResponseEntity<AppointmenDto> getAppointmentById(@PathVariable("id")Long appointmentId){
			AppointmenDto appointmentDto = appointmentService.getAppointmentById(appointmentId);
			return ResponseEntity.ok(appointmentDto);
		}
//Build Get All Appointment REST API
	    //@PreAuthorize("hasAnyRole('ADMIN','USER')")
		@GetMapping
		public ResponseEntity<List<AppointmenDto>> getAllAppointments(){
			List<AppointmenDto> appointments = appointmentService.getAllAppointments();
			return ResponseEntity.ok(appointments);
			}
		//Build Update Appointment REST API
	    //@PreAuthorize("hasRole('ADMIN')")
		@PutMapping("{id}")
		public ResponseEntity<AppointmenDto> updateAppointment(@PathVariable("id")Long appointmentId, 
				@RequestBody AppointmenDto updatedAppointment){
			AppointmenDto appointmentDto =appointmentService.updateAppointment(appointmentId, updatedAppointment);
			return ResponseEntity.ok(appointmentDto);
		}
		//Build Delete Appointment REST API
	    //@PreAuthorize("hasRole('ADMIN')")
		@DeleteMapping("{id}")
		public ResponseEntity<String> deleteAppointment(@PathVariable("id") Long appointmentId){
			appointmentService.deleteAppointment(appointmentId);
			return ResponseEntity.ok("Patient deleted successfully!");
		}
		
}
