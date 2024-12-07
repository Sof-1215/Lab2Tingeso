import axios from "axios";

const BackendServer = import.meta.env.VITE_PAYROLL_BACKEND_SERVER; // localhost o ip
const BackendPort = import.meta.env.VITE_PAYROLL_BACKEND_PORT; // puerto del backend

export default axios.create({
    baseURL: `http://localhost:8088`,
    headers: {
        'Content-Type': 'application/json'
    }
});