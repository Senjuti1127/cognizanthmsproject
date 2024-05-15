import React, {useEffect, useState} from 'react'
import { deleteDoctor, listDoctors } from '../services/DoctorService'
import { useNavigate } from 'react-router-dom'

const ListDoctorComponent = () => {
 
 const [doctors , setDoctors] =useState([])

 const navigator = useNavigate();

 useEffect(()=>{
    getAllDoctors();

 }, [])

 function getAllDoctors()
 {
    listDoctors().then((response) =>{
        setDoctors(response.data) ; 
      }).catch(error =>{
          console.error(error);
      })
 }

 function addNewDoctor(){
       navigator('/add-doctor')
 }

 function updateDoctor(id){
    navigator(`/edit-doctor/${id}`)
 }

 function removeDoctor(id){
    console.log(id);

    deleteDoctor(id).then((response) => {
        getAllDoctors();
    }).catch(error => {
        console.error(error);
    })
 }
 
    return (
    <div className='container'>
        <h2 className='text-center'>List of Doctors</h2>
        
        <table className='table table-striped table-bordered'>
            <thead>
                <tr>
                    <th>Doctor Id</th>
                    <th>Doctor FirstName</th>
                    <th>Doctor LastName</th>
                    <th>Doctor Email Id</th>
                    <th>Actions</th>
                </tr>
            </thead>
           <tbody>
            {
                doctors.map(doctor =>
                    <tr key={doctor.id}>
                        <td>{doctor.id}</td>
                        <td>{doctor.firstName}</td>
                        <td>{doctor.lastName}</td>
                        <td>{doctor.email}</td>
                        <td>
                            <button className='btn btn-info' onClick={() => updateDoctor(doctor.id)}>Update</button>
                            <button className='btn btn-danger' onClick={() => removeDoctor(doctor.id)}
                            style={{marginLeft:'10px'}}>Delete</button>
                            
                            </td>
                    </tr>)
            }
        
            </tbody> 
        </table>
    </div>
  )
}

export default ListDoctorComponent;