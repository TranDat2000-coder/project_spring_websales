import axios from "axios";

const API_URL = "http://localhost:8081";

class AuthService {
  login(username, password) {
    debugger;
    return axios
      .post(API_URL + "/login", {
        username,
        password
      })
      .then(response => {
        if (response.data.token) {
          localStorage.setItem("user", JSON.stringify(response.data));
        }

        return response;
      });
  }

  // logout() {
  //   localStorage.removeItem("user");
  // }

  // register(username, email, password) {
  //   return axios.post(API_URL + "signup", {
  //     username,
  //     email,
  //     password
  //   });
  // }

  getCurrentUser() {
    return JSON.parse(localStorage.getItem('user'));;
  }
}

export default new AuthService();
