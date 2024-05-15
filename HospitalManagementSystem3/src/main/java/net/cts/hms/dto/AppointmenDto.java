package net.cts.hms.dto;

import java.util.List;
import net.cts.hms.entity.Doctor;
//import net.cts.hms.entity.Services;


public class AppointmenDto {
     
	 private Long id;
     
     
	 private String patient_fName;
     
	 private String patient_lName;
     
	 private String illness;
	  
     
     
     
    
     
	public AppointmenDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AppointmenDto(Long id, String patient_fName, String patient_lName, String illness) {
		super();
		this.id = id;
		this.patient_fName = patient_fName;
		this.patient_lName = patient_lName;
		this.illness = illness;
		
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPatient_fName() {
		return patient_fName;
	}
	public void setPatient_fName(String patient_fName) {
		this.patient_fName = patient_fName;
	}
	public String getPatient_lName() {
		return patient_lName;
	}
	public void setPatient_lName(String patient_lName) {
		this.patient_lName = patient_lName;
	}
	public String getIllness() {
		return illness;
	}

	public void setIllness(String illness) {
		this.illness = illness;
	}
	 
}

