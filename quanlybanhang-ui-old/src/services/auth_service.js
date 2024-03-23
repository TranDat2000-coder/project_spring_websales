import axios from "axios";
import TokenService from "./token_service";

const API_URL = "http://localhost:8082/api/auth";

// const login = (username, password) => {
//     return api.post("/generateToken", { username, password }).then((res) => {
//         debugger;
//         if (res.data.token) {
//             TokenService.setUser(res.data);
//         }
//         return res.data;
//     });
// };

const login = (username, password) => {
    return axios.post(API_URL + "/generateToken", {
        username, password
    }).then((res) => {
        if (res.data.token) {
            localStorage.setItem("user", JSON.stringify(res.data));
        }

        return res.data
    })
}

const logOut = () => {
    localStorage.removeItem("user");
}

const getCurrentUser = () => {
    return JSON.parse(localStorage.getItem("user"))
}

const AuthService = {
    login,
    getCurrentUser,
    logOut
}

export default AuthService;