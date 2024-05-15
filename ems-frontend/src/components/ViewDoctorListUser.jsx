import React, { useEffect, useState } from 'react'
import { listDoctors } from '../services/DoctorService';

const ViewDoctorListUser = () => {
  const [doctors , setDoctors] =useState([]);


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
            </tr>
        </thead>
       <tbody>
        {
            doctors.map(doctor =>
                (<tr key={doctor.id}>
                    <td>{doctor.id}</td>
                    <td>{doctor.firstName}</td>
                    <td>{doctor.lastName}</td>
                    <td>{doctor.email}</td>
                </tr>))
        }
    
        </tbody> 
    </table>
</div>
  )
}

export default ViewDoctorListUser;