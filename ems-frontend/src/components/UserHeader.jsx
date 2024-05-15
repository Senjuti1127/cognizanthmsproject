import { Link, useNavigate } from "react-router-dom";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
 
const UserHeader = () => {
  let navigate = useNavigate();
 
  const userLogout = () => {
    toast.success("logged out!!!", {
      position: "top-center",
      autoClose: 1000,
      hideProgressBar: false,
      closeOnClick: true,
      pauseOnHover: true,
      draggable: true,
      progress: undefined,
    });
    sessionStorage.removeItem("active-user");
    window.location.reload(true);
    navigator("/user/login");
  };
 
  return (
    <ul class="navbar-nav ms-auto mb-2 mb-lg-0 me-5">
      <li class="nav-item">
        <Link to="/ViewDoctorListUser" class="nav-link active" aria-current="page">
          <b className="text-color">List of Doctors</b>
        </Link>
      </li>
 
      <li class="nav-item">
        <Link to="/ViewAppointmentListUser" class="nav-link active" aria-current="page">
          <b className="text-color">List of Appointments</b>
        </Link>
      </li>
 
      <li class="nav-item">
        <Link
          to="/user/login"
          class="nav-link active"
          aria-current="page"
          onClick={userLogout}
        >
          <b className="text-color">Logout</b>
        </Link>
        <ToastContainer />
      </li>
    </ul>
  );
};
 
export default UserHeader;
 