
import './App.css'
import FooterComponent from './components/FooterComponent'
import HeaderComponent from './components/HeaderComponent'
import ListDoctorComponent from './components/ListDoctorComponent'
import DoctorComponent from './components/DoctorComponent'
import {BrowserRouter, Routes , Route} from 'react-router-dom'
import ListAppointmentComponent from './components/ListAppointmentComponent'
import AppointmentComponent from './components/AppointmentComponent'
import HomeComponent from './components/HomeComponent'
import Register from './components/Register'
import Login from './components/Login'
import ViewDoctorListUser from './components/ViewDoctorListUser'
import ViewAppointmentListUser from './components/ViewAppointmentListUser'





function App() {

  return (
    <>

    <BrowserRouter>
     <HeaderComponent />
     

     <Routes>
      {/* //http://localhost:3000 */}
     <Route path = '/' element={<HomeComponent/>}></Route>
     {/* http://localhost:3000/all */}
     <Route path = '/all' element={<HomeComponent/>}></Route>

     {/* //http://localhost:3000/doctors */}
     <Route path = '/doctors' element={<ListDoctorComponent/>}></Route>
     {/* //http://localhost:3000/add-doctor */}
     <Route path = '/add-doctor' element={<DoctorComponent/>}></Route>

     {/* //http://localhost:3000/user/register */}
     <Route path = '/user/register' element={<Register/>}></Route>

     {/* //http://localhost:3000/user/login */}
     <Route path = '/user/login' element={<Login/>}></Route>
     
     {/* //http://localhost:3000/edit-doctor */}
     <Route path='/edit-doctor/:id' element={<DoctorComponent/>}></Route>

     {/* //http://localhost:3000/appointments */}
     <Route path='/appointments' element={<ListAppointmentComponent/>}></Route>
      
      {/* //http://localhost:3000/add-appointment */}
      <Route path='/add-appointment' element={<AppointmentComponent/>}></Route>

      {/* //http://localhost:3000/edit-appointment */}
     <Route path='/edit-appointment/:id' element={<AppointmentComponent/>}></Route>

    {/* //http://localhost:3000/ViewDoctorListUser*/}
    <Route path='/ViewDoctorListUser' element={<ViewDoctorListUser/>}></Route>


   {/* //http://localhost:3000/ViewDoctorListUser*/}
   <Route path='/ViewAppointmentListUser' element={<ViewAppointmentListUser/>}></Route>


     
     </Routes>
    
     <FooterComponent/>
     </BrowserRouter>
    </>
  )
}

export default App;
