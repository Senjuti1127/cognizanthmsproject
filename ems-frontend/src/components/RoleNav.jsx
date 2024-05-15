import AdminHeader from "./AdminHeader";
import UserHeader from "./UserHeader";
import HeaderComponent from "./NormalHeader";

 
const RoleNav = () => {
  const user = JSON.parse(sessionStorage.getItem("active-user"));
  const admin = JSON.parse(sessionStorage.getItem("active-admin"));
 
  if (user != null) {
    return <UserHeader/>;
  } else if (admin != null) {
    return <AdminHeader />;
  } else {
    return <HeaderComponent />;
  }
};
 
export default RoleNav;