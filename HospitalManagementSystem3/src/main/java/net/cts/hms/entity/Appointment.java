package net.cts.hms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Appointment")
public class Appointment {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
     
     @Column(name="patient_fName")
	 private String patient_fName;
     @Column(name="patient_lName")
	 private String patient_lName;
     @Column(name="Illness")
	 private String illness;
	  
	 
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Appointment(Long id, String patient_fName, String patient_lName, String illness) {
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
