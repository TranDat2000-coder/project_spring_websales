
import axios from 'axios';

const API_URL = "http://localhost:8082/api/auth";

const login = async (username, password) => {
    const res = await axios.post(API_URL + "/generateToken", {
        username, password
    });
    if (res.data.token) {
        localStorage.setItem("user", JSON.stringify(res.data));
    }
    return res.data;
}

const logout = () => {
    localStorage.removeItem("user");
};

const getCurrentUser = () => {
    return JSON.parse(localStorage.getItem("user"))
}

const AuthService = {
    login,
    logout,
    getCurrentUser
};

export default AuthService;