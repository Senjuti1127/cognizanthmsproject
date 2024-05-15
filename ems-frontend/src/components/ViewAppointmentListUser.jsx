import React, { useEffect, useState } from 'react'
import { getAllAppointments } from '../services/AppointmentService';

const ViewAppointmentListUser = () => {
  const [appointments,setAppointments] = useState([]);

  useEffect ( () => {
    listOfAppointments();
  }, [])

  function listOfAppointments(){
    getAllAppointments().then((response)=>{
        console.log(response.data);
        setAppointments(response.data);
    }).catch(error => {
        console.error(error);
    })
  }

  return (
    <div className='container'>
     <h2 className='text-center'>Appointments List</h2>
     
        <table className='table table-striped table-bordered'>
        <thead>
                <tr>
                    <th>Appointment Id</th>
                    <th>Patient F_Name</th>
                    <th>Patient L_Name</th>
                    <th>Illness</th>
                    
                    
                </tr>
            </thead>
          <tbody>
          {
                    appointments.map( appointment=> 
                            <tr key={appointment.id}>
                                <td> {appointment.id} </td>
                                <td> {appointment.patient_fName} </td>
                                <td> {appointment.patient_lName} </td>
                                <td> {appointment.illness} </td>
                                
                            
                            
                            </tr>
                        )
                }
          </tbody>
        </table>
    </div>
  )
}

export default ViewAppointmentListUser;