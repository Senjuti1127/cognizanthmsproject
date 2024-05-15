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

import net.cts.hms.dto.Doctordto;
import net.cts.hms.exception.ResourceNotFoundException;
import net.cts.hms.service.DoctorService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
@Autowired
	private DoctorService doctorService;
	
	public DoctorController(DoctorService doctorService) {
		super();
		this.doctorService = doctorService;
	}
//
//	public DoctorController() {
//		super();
//		// TODO Auto-generated constructor stub
//	}

	// Build Add Doctor REST API
	
	@PostMapping
	public ResponseEntity<Doctordto> createDoctor(@RequestBody Doctordto doctordto)
	{
		Doctordto saveDoctor = doctorService.createDoctor(doctordto);
		return new ResponseEntity<>(saveDoctor, HttpStatus.CREATED);
	}
	
	//Build Get Doctor REST API
	
	@GetMapping("{id}")
	public ResponseEntity<Doctordto> getDoctorById(@PathVariable("id")Long doctorId){
		Doctordto doctordto = doctorService.getDoctorById(doctorId);
		if(!doctordto.equals(null)) {
			return new ResponseEntity<Doctordto>(doctordto,HttpStatus.OK);
		}else {
			throw new ResourceNotFoundException("The Id is not there");
		}
	
	}
	
	//Build Get All Doctors REST API
	
	@GetMapping
	public ResponseEntity<List<Doctordto>> getAllDoctors(){
		List<Doctordto> doctors = doctorService.getAllDoctors();
		if(doctors.isEmpty())
		{
			throw new ResourceNotFoundException("There is no data present");
			}
		else {
			return new ResponseEntity<List<Doctordto>>(doctors,HttpStatus.OK);
		    }
		}
	//Build Update Doctors REST API
	
	@PutMapping("{id}")
	public ResponseEntity<Doctordto> updateDoctor(@PathVariable("id")Long doctorId, @RequestBody Doctordto updateDoctor){
		Doctordto doctordto =doctorService.updateDoctor(doctorId, updateDoctor);
		return ResponseEntity.ok(doctordto);
	}

	//Build Delete Doctors REST API
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteDoctor(@PathVariable("id") Long doctorId){
		doctorService.deleteDoctor(doctorId);
		return ResponseEntity.ok("Employee deleted successfully!");
	}
}
