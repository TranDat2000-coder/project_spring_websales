import axios from "axios";
import { request } from "./auth-header";

const API_URL = "http://localhost:8082";

const register = (username, email, password) => {
  return axios.post(API_URL + "signup", {
    username,
    email,
    password,
  });
};

const login = (username, password) => {
  debugger;
  return axios
    .post(API_URL + "/login", {
      username,
      password,
    })
    .then((response) => {
      if (response.data.token) {
        localStorage.setItem("user", JSON.stringify(response.data));
      }

      return response.data;
    });
};

// export const login = (formData) => {
//   debugger;
//   return request({
//     url: API_URL + "/login",
//     method: "POST",
//     body: JSON.stringify(formData)
//   });
// }

const logout = () => {
  localStorage.removeItem("user");
};

const getCurrentUser = () => {
  return JSON.parse(localStorage.getItem("user"));
};

const AuthService = {
  register,
  login,
  logout,
  getCurrentUser,
};

export default AuthService;
