import React, { useEffect, useState } from 'react'
import { createDoctor, getDoctor, updateDoctor } from '../services/DoctorService'
import { useNavigate,useParams } from 'react-router-dom'
import { getAllAppointments } from '../services/AppointmentService'

const DoctorComponent = () => {

  const [firstName, setFirstName] = useState('')
  const [lastName, setLastName] = useState('')
  const [email, setEmail] = useState('')
  const[appointmentId,setAppointmentId] = useState('')
  const [appointments,setAppointments] =useState([])

 useEffect(()=>{
      
     getAllAppointments().then((response)=>{
                 setAppointments(response.data);
     }).catch(error =>{
      console.error(error);
     })

 }, [])

  const {id} = useParams();

  const[errors,setErrors]=useState({
    firstName:'',
    lastName:'',
    email:'',
    appointment:''
  })

  const navigator = useNavigate();

  useEffect(() =>{
      
    if(id){
      getDoctor(id).then((response)=> {
        setFirstName(response.data.firstName);
        setLastName(response.data.lastName);
        setEmail(response.data.email);
        setAppointmentId(response.data.appointmentId);
      }).catch(error =>{
         console.error(error);
      })

    }
  }, [id])

function saveorUpdateDoctor(e){
 e.preventDefault();

 if(validateForm()){
  
const doctor = {firstName,lastName,email,appointmentId}
 console.log(doctor)

if (id){
  updateDoctor(id, doctor).then((response)=> {
    console.log(response.data);
    navigator('/doctors')
  }).catch(error => {
    console.error(error);
  })
  

 } else{
  createDoctor(doctor).then((response)=>{
    console.log(response.data);
    navigator('/doctors')
   }).catch(error=>{
    console.error(error);
   })
 }

  }
}

  function validateForm(){
    let valid = true;

    const errorsCopy = {... errors}
   if(firstName.trim()){
       errorsCopy.firstName = '';
      }else{
        errorsCopy.firstName='First name is required';
        valid= false;
      }

      if(lastName.trim()){
        errorsCopy.lastName='';
      }else{
        errorsCopy.lastName='Last name is required';
        valid = false;
      }

      if(email.trim()){
        errorsCopy.email ='';
      }else{
        errorsCopy.email='Email is required';
        valid = false;
      }
      if(appointmentId){
        errorsCopy.appointment = '';
      }else{
        errorsCopy.appointment = 'Select Appointment';
        valid = false;
      }

    setErrors(errorsCopy);

    return valid;

  }

  function pageTitle(){
       if(id){
        return <h2 className='text-center'>Update Doctor</h2>
       }else{
        return <h2 className='text-center'>Add Doctor</h2>
       }
  }

  return (
    <div className='container'>
      <br></br>
      <div className='row'>
        <div className='card col-md-6 offset-md-3 offset-md-3'>
             {
              pageTitle()
             }
        <div className='card-body'>
         <form>
           <div className='form-group mb-2'>
              <label className='form-label'>First Name:</label>
           <input
           type='text'
           placeholder='Enter Doctor FirstName'
           name='firstName'
           value={firstName}
           className={`form-control ${errors.firstName?'is-invalid':''}`}
           onChange={(e)=> setFirstName(e.target.value)}> 
           </input>
         
         {errors.firstName && <div className='invalid-feedback'>{errors.firstName}</div>}

           </div>

           <div className='form-group mb-2'>
              <label className='form-label'>Last Name:</label>
           <input
           type='text'
           placeholder='Enter Doctor lastName'
           name='lastName'
           value={lastName}
           className={`form-control ${errors.lastName?'is-invalid':''}`}
           onChange={(e) => setLastName(e.target.value)}> 
           </input>
           {errors.lastName && <div className='invalid-feedback'>{errors.lastName}</div>}
           </div>

           <div className='form-group mb-2'>
              <label className='form-label'>Email:</label>
           <input
           type='text'
           placeholder='Enter Doctor Email'
           name='Email'
           value={email}
           className={`form-control ${errors.email?'is-invalid':''}`}
           onChange={(e)=> setEmail(e.target.value)}> 
           </input>
           {errors.email && <div className='invalid-feedback'>{errors.email}</div>}
           </div>


    
    <div className='form-group mb-2'>
          <label className='form-label'>Select Appointment:</label>
           <select
                 className={`form-control ${errors.appointment?'is-invalid':''}`}
                  value={appointmentId}
                  onChange={(e) =>setAppointmentId(e.target.value)} >
                 
                 <option value="Select Appointment">Select Appointment</option>
                 {
                  
                  appointments.map( appointment=>
                   <option key ={appointment.id} value={appointment.id}>{appointment.patient_fName}</option> )
                 }

                  </select>
           {errors.appointment && <div className='invalid-feedback'>{errors.appointment}</div>}
           </div>


    <button className='btn btn btn-info' onClick={saveorUpdateDoctor}>Submit</button>
    
     </form>
     
   </div>

 </div>
 </div>
</div>
  )
}

export default DoctorComponent;