import React from 'react'

const HomeComponent = () => {
  return (
    <div className="homepage">
    
      <section className="hero">
      <div className="col-md-15"> </div>
          <h1 className="display-4 my-2"  style={{ color: '#007bff', textShadow: '8px 6px 7px rgba(0, 0, 0, 0.5)' ,fontFamily:"cursive"}}>HEALTH HUB</h1>
          <div className="card" style={{ backgroundColor: 'rgba(255, 255, 255, 0.8)' }}>
            <div className="card-body">
              <h5 className="card-title">Best Healthcare Facilities</h5>
              <p className="card-text">Health Hub provides a broad range of diagnostic and therapeutic services to patients suffering from diseases. </p>
              <button type="button" className="btn btn-primary">Learn More</button>
            </div>
          </div>
          
      </section>

      <section className="about-us">
        <h2>About Us</h2>
        <p>
          Our mission is to provide high-quality healthcare services through
          efficient management and cutting-edge technology.
        </p>
      </section>

      <section className="services">
        <h2>Our Services</h2>
        <div className="card-container">
          <div className="card">
            <h3>Appointment Scheduling</h3>
            <p>
              Schedule appointments with ease and manage them efficiently.
            </p>
          </div>
          <div className="card">
            <h3>Patient Records</h3>
            <p>
              Access and manage patient records securely and conveniently.
            </p>
          </div>
          <div className="card">
            <h3>Hospital Operations</h3>
            <p>
              Streamline hospital operations, including inventory management,
              staff scheduling, and billing.
            </p>
          </div>
        </div>
      </section>

      
    </div>
  )
}

export default HomeComponent;