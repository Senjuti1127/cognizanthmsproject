package net.cts.hms;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import net.cts.hms.controller.DoctorController;
import net.cts.hms.dto.Doctordto;
import net.cts.hms.service.DoctorService;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HospitalManagementSystemApplicationTests {

    @InjectMocks
    private DoctorController doctorController;

    @Mock
    private DoctorService doctorService;

    @Test
    public void testCreateDoctor() {
        // Create a dummy doctor DTO
        Doctordto doctordto = new Doctordto();
        doctordto.setFirstName("John");
        doctordto.setLastName("Dey");

        // Mock the doctor service to return the created doctor DTO
        when(doctorService.createDoctor(doctordto)).thenReturn(doctordto);

        // Call the createDoctor method
        ResponseEntity<Doctordto> response = doctorController.createDoctor(doctordto);

        // Verify the response
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(doctordto, response.getBody());
    }

    @Test
    public void testGetDoctorById() {
        // Create a dummy doctor DTO
        Doctordto doctordto = new Doctordto();
        doctordto.setId(1L);
        doctordto.setFirstName("senjuti ");
        doctordto.setLastName("Dey");

        // Mock the doctor service to return the doctor DTO
        when(doctorService.getDoctorById(1L)).thenReturn(doctordto);

        // Call the getDoctorById method
        ResponseEntity<Doctordto> response = doctorController.getDoctorById(1L);

        // Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(doctordto, response.getBody());
    }

    @Test
    public void testupdateDoctor() {
       // Create a dummy doctor DTO
       Doctordto doctordto = new Doctordto();
       doctordto.setId(1L);
       doctordto.setFirstName("John");
       doctordto.setLastName("Drigger");
     
     
       when(doctorService.updateDoctor(1L, doctordto)).thenReturn(doctordto);
     
       // Call the createDoctor method
       ResponseEntity<Doctordto> response = doctorController.updateDoctor(1L, doctordto);
     
       // Verify the response
       assertEquals(HttpStatus.OK, response.getStatusCode());
       assertEquals(doctordto, response.getBody());
    }
     
     @Test
   public void testdeleteDoctor() {
       
      Doctordto doctordto = new Doctordto();
      doctordto .setId(1L);
      doctordto .setFirstName("John");
      doctordto .setLastName("Drigger");
      doctorService.deleteDoctor(1L);
    
       ResponseEntity<String> response = doctorController.deleteDoctor(1L);
   
      assertEquals(HttpStatus.OK, response.getStatusCode());
   }
   
    

   

    
}