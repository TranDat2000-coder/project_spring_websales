
import axios from "axios";
import { API_BASE_LOGIN_URL } from "./constants";

class AuthService {

    login(username, password) {
        return axios
            .post(API_BASE_LOGIN_URL + "/login", {
                username,
                password
            }).then(response => {
                if (response.data.token) {
                    localStorage.setItem("user", JSON.stringify(response.data));
                }
                return response.data;
            })
    }

    getCurrentUser = () => {
        return JSON.parse(localStorage.getItem('user'));
    }
}

export default new AuthService();