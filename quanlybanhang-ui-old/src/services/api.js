import axios from "axios";

const instance = axios.create({
    baseURL: "http://localhost:8082",
    headers: {
        "Content-Type": "application/json",
    },
});

instance.interceptors.response.use((res) => {
    return res;
}, async (err) => {
    const originalConfig = err.config;
}
);

export default instance;
