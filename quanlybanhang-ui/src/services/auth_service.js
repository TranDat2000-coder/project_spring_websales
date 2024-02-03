
import api from "./api";
import TokenService from "./token_service";

const login = (username, password) => {
    return api.post("/generateToken", { username, password }).then((res) => {
        if (res.data.token) {
            TokenService.setUser(res.data);
        }
        return res.data;
    });
};

const logOut = () => {
    TokenService.removeUser();
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