import React from 'react'
import { NavLink } from 'react-router-dom'
import RoleNav from './RoleNav';


const HeaderComponent = () => {
  return (
    <div>
      <header>
        <nav className='navbar navbar-expand-lg navbar-light' >
          <a className="navbar-brand" href="https://www.hospital.net">Hospital Management System</a>
          <div className="collapse navbar-collapse" id="navbarNav">
            <ul className="navbar-nav">
              <li className="nav-item" >
                <b><NavLink className="nav-link" to='/all'>Home</NavLink></b>
              </li>
              {/* <li className="nav-item" >
                <NavLink className="nav-link" to='/doctors'>Doctors</NavLink>
              </li>
              <li className="nav-item">
                <NavLink className="nav-link" to='/appointments'>Appointments</NavLink>
              </li> */}
            </ul>
            <RoleNav />
          </div>
        </nav>
        
      </header>
    </div>

  );
}

export default HeaderComponent;