import { Link, useNavigate} from "react-router-dom";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
 
const AdminHeader = () => {
  let navigate = useNavigate();
  
 
  const user = JSON.parse(sessionStorage.getItem("active-admin"));
  console.log(user);
 
  const adminLogout = () => {
    
    toast.success("logged out!!!", {
      position: "top-center",
      autoClose: 1000,
      hideProgressBar: false,
      closeOnClick: true,
      pauseOnHover: true,
      draggable: true,
      progress: undefined,
    });
    sessionStorage.removeItem("active-admin");
   window.location.reload(true);
   navigator("/user/login");
   
  };
 
  return (
    <ul class="navbar-nav ms-auto mb-2 mb-lg-0 me-5">
      <li class="nav-item">
        <Link to="/add-doctor" class="nav-link active" aria-current="page">
          <b className="text-color"> Add Doctor</b>
        </Link>
      </li>
 
      <li class="nav-item">
        <Link to="/doctors" class="nav-link active" aria-current="page">
          <b className="text-color">List of Doctors</b>
        </Link>
      </li>
 
      <li class="nav-item">
        <Link
          to="/add-appointment"
          class="nav-link active"
          aria-current="page"
        >
          <b className="text-color">Add Appointment</b>
        </Link>
      </li>
 
      <li class="nav-item">
        <Link
          to="/appointments"
          class="nav-link active"
          aria-current="page"
        >
          <b className="text-color">List of Appointment</b>
        </Link>
      </li>
 
      <li class="nav-item">
        <Link
          to="/user/login"
          class="nav-link active"
          aria-current="page"
          onClick={adminLogout}
        >
          <b className="text-color">Logout</b>
        </Link>
        <ToastContainer />
      </li>
    </ul>
  );
};
 
export default AdminHeader;