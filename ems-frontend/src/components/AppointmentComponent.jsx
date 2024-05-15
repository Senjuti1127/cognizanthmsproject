import React, { useEffect, useState } from 'react'
import { createAppointment, getAppointmentById, updateAppointment } from '../services/AppointmentService'
import { useNavigate, useParams} from 'react-router-dom'
const AppointmentComponent = () => {

    const [patient_fName, setPatient_fName] = useState('')
    const [patient_lName, setPatient_lName] = useState('')
    const [illness, setIllness] = useState('')

    const {id} = useParams();
    const navigator = useNavigate();


    useEffect(()=>{

        getAppointmentById(id).then((response)=> {
            setPatient_fName(response.data.patient_fName);
            setPatient_lName(response.data.patient_lName);
            setIllness(response.data.illness)
        }).catch(error => {
            console.error(error);
        })

    }, [id])

  function saveOrUpdateAppointment(e){
    e.preventDefault();

    const appointment = {patient_fName,patient_lName,illness }
    console.log(appointment);

   if(id){
     
    updateAppointment(id, appointment).then((response)=>{
        console.log(response.data);
        navigator('/appointments')
    }).catch(error =>{
        console.error(error);
    })
 } 
 else{
    createAppointment(appointment).then((response)=>{
        console.log(response.data);
        navigator('/appointments')
    }).catch(error =>{
        console.error(error);
    })

   }
 }

  function pageTitle(){
     if(id){
        return <h2 className='text-center'>Update Appointment</h2>
     } else{
        return <h2 className='text-center'>Add Appointment</h2>
     }
  }

  return (
    <div className='container'> <br></br>
        <div className='row'>
            <div className='card col-md-6 offset-md-3 offset-md-3'>
               {
                pageTitle()
               }
            
            <div className='card-body'>
                <form>

                 <div className='form-group mb-2'>
                     <label className='form-label'>Patient FirstName</label>
                     <input
                     type='text'
                     name='patientfName'
                     placeholder='Enter Patient FirstName'
                     value={patient_fName}
                     onChange={(e)=> setPatient_fName(e.target.value)}
                     className='form-control'></input>
                  </div>

                  <div className='form-group mb-2'>
                     <label className='form-label'>Patient LastName</label>
                     <input
                     type='text'
                     name='patientlName'
                     placeholder='Enter Patient LastName'
                     value={patient_lName}
                     onChange={(e)=> setPatient_lName(e.target.value)}
                     className='form-control'></input>
                  </div>
 
                  <div className='form-group mb-2'>
                     <label className='form-label'>Illness</label>
                     <input
                     type='text'
                     name='illness'
                     placeholder='Enter illness'
                     value={illness}
                     onChange={(e)=> setIllness(e.target.value)}
                     className='form-control'></input>
                  </div>

                  <button className='btn btn-success mb-2'onClick={(e)=> saveOrUpdateAppointment(e)}>Submit</button>
             </form>
            </div>
            
            
            </div>

        </div>
    </div>
  )
}

export default AppointmentComponent;