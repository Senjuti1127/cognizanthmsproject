import axios from "axios";
const REST_API_BASE_URL='http://localhost:8080/api/doctors';

export const listDoctors = () => axios.get(REST_API_BASE_URL);

export const createDoctor = (doctor) => axios.post(REST_API_BASE_URL, doctor);

export const getDoctor = (doctorId) => axios.get(REST_API_BASE_URL + '/'+ doctorId);

export const updateDoctor = (doctorId, doctor) => axios.put(REST_API_BASE_URL + '/'+ doctorId,doctor);

export const deleteDoctor = (doctorId) => axios.delete(REST_API_BASE_URL +'/'+ doctorId);