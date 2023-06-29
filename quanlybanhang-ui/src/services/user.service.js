import axios from "axios";
import authHeader, { request } from "./auth-header";

const API_URL = "http://localhost:8082/admin";

// const getPublicContent = () => {
//   return axios.get(API_URL + "/home", { headers: authHeader() });
// };

export const getPublicContent = () => {
  return request({
    url: API_URL + "/home",
    method: "GET",
    body: JSON.stringify()
  });
}

const getUserBoard = () => {
  return axios.get(API_URL + "user", { headers: authHeader() });
};

const getModeratorBoard = () => {
  return axios.get(API_URL + "mod", { headers: authHeader() });
};

const getAdminBoard = () => {
  return axios.get(API_URL + "admin", { headers: authHeader() });
};

const UserService = {
  getPublicContent,
  getUserBoard,
  getModeratorBoard,
  getAdminBoard,
};

export default UserService;
