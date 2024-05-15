import React, { useEffect, useState } from 'react'
import { Link, useNavigate} from 'react-router-dom'
import { deleteAppointment, getAllAppointments } from '../services/AppointmentService'

const ListAppointmentComponent = () => {
  const [appointments,setAppointments] = useState([]);

  
const navigator = useNavigate() ;
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

  function updateAppointment(id){
        navigator(`/edit-appointment/${id}`)
  }

  function removeAppointment(id){
      deleteAppointment(id).then((response)=>{
        console.log(response.data);

     listOfAppointments();
    }).catch(error =>{
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
                    <th>Actions</th>
                    
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
                                <td>
                                    <button onClick={()=>updateAppointment(appointment.id)} className='btn btn-info'>Update</button>
                                     <button onClick={()=>removeAppointment(appointment.id)} className='btn btn-danger'
                                     style={{marginLeft:"10px"}}>Delete</button>
                                </td>
                            
                            
                            </tr>
                        )
                }
          </tbody>
        </table>
    </div>
  )
}

export default ListAppointmentComponent;