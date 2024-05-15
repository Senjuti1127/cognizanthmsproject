import { useState } from "react";
import "react-toastify/dist/ReactToastify.css";
import { ToastContainer, toast } from "react-toastify";
import { useNavigate } from "react-router-dom";

 
const Register = () => {
  const [user, setUser] = useState({
    firstName: "",
    lastName: "",
    emailId: "",
    password: "",
    role: "",
  });
  
 
  const handleUserInput = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };
 
  const saveUser = (event) => {
    event.preventDefault();
    fetch("http://localhost:8080/api/user/register", {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      body: JSON.stringify(user),
    }).then((result) => {
      console.log("******near toast thing");
      toast.success("Registered Successfully!!!", {
        position: "top-center",
        autoClose: 1000,
        hideProgressBar: false,
        closeOnClick: true,
        pauseOnHover: true,
        draggable: true,
        progress: undefined,
      });
      
      console.warn("result", result);
      result
        .json()
        .then((res) => {
          console.log("response", res);
        })
        .catch((error) => {
          console.log("******", error);
          console.log(error);
        });

         });
};

  return (
    <div className="container">
      <div class="mt-2 d-flex aligns-items-center justify-content-center ms-2 me-2 mb-2">
        <div
          class="card form-card border-color text-color custom-bg col-md-7 "
          style={{ width: "25rem" }}
        >
          <div className="card-header bg-secondary custom-bg-text text-center">
            <h6 class="card-title">REGISTER</h6>
          </div>
          <div class="card-body">
            <form onSubmit={saveUser}>
              <div class="mb-1 text-color">
                <label for="role" class="form-label">
                  <b>Choose Your Role</b>
                </label>
                <select
                  onChange={handleUserInput}
                  className="form-control"
                  name="role"
                >
                  <option value="0">Select Role</option>
                  <option value="Admin"> Admin </option>
                  <option value="User"> User </option>
                </select>
              </div>
 
              <div class="mb-1 text-color">
                <label for="title" class="form-label">
                  <b> First Name</b>
                </label>
                <input
                  type="text"
                  class="form-control"
                  id="firstName"
                  name="firstName"
                  onChange={handleUserInput}
                  value={user.firstName}
                />
              </div>
              <div class="mb-1 text-color">
                <label for="description" class="form-label">
                  <b>Last Name</b>
                </label>
                <input
                  type="text"
                  class="form-control"
                  id="lastName"
                  name="lastName"
                  onChange={handleUserInput}
                  value={user.lastName}
                />
              </div>
 
              <div className="mb-1 text-color">
                <b>
                  <label className="form-label">Email Id</label>
                </b>
                <input
                  type="email"
                  class="form-control"
                  id="emailId"
                  name="emailId"
                  onChange={handleUserInput}
                  value={user.emailId}
                />
              </div>
 
              <div class="mb-1 mt-1">
                <b>
                <label for="quantity" class="form-label">
                  Password
                </label></b>
                <input
                  type="password"
                  class="form-control"
                  id="password"
                  name="password"
                  onChange={handleUserInput}
                  value={user.password}
                />
              </div>
 
              <input
                type="submit"
                class="btn btn-primary custom-bg-text"
                value="Register"
              />
 
              <ToastContainer />
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};
 
export default Register;