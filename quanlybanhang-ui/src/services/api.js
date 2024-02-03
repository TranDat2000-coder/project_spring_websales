import axios from "axios";
import TokenService from "./token_service";

const instance = axios.create({
    baseURL: "http://localhost:8082",
    headers: {
        "Content-Type": "application/json",
    },
});

instance.interceptors.response.use((res) => {
    return res;
}, async (err) => {
    debugger;
    const originalConfig = err.config;
}
);

export default instance;
