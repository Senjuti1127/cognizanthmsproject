import axios from "axios";

const APPOINTMENT_REST_API_BASE_URL ='http://localhost:8080/api/appointments';

export const getAllAppointments = () => axios.get(APPOINTMENT_REST_API_BASE_URL);
export const createAppointment = (appointment)=> axios.post(APPOINTMENT_REST_API_BASE_URL,appointment);
export const getAppointmentById = (appointmentId)=> axios.get(APPOINTMENT_REST_API_BASE_URL+'/'+appointmentId);
export const updateAppointment = (appointmentId,appointment)=>axios.put(APPOINTMENT_REST_API_BASE_URL + '/'+ appointmentId, appointment);
export const deleteAppointment = (appointmentId) => axios.delete(APPOINTMENT_REST_API_BASE_URL+'/'+appointmentId);