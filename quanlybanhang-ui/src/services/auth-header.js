import EventBus from "../common/EventBus";
import { useNavigate } from "react-router-dom";
import AuthService from "./auth.service";

export default function authHeader() {
  const user = JSON.parse(localStorage.getItem('user'));
  debugger;
  if (user && user.token) {
    return { Authorization: 'Bearer ' + user.token }; // for Spring Boot back-end
    // return { 'x-access-token': user.accessToken };       // for Node.js Express back-end
  } else {
    return {};
  }
}

export async function request(options) {
  debugger;
  const user = JSON.parse(localStorage.getItem('user'));
  let navigate = useNavigate();
  if (user !== null) {
    let accessToken = user.token;

    const authorizationStr = 'Bearer '.concat(accessToken);
    const headers = { "Content-Type": 'application/json', "Authorization": authorizationStr };
    options.headers = headers;

    try {
      const response = await fetch(options.url, options);
      if (!response.ok && (response.status === 401 || response.status === 500)) {
        throw new Error("Phiên đăng nhập hết hạn.");
      } else {
        const json = await response.json();
        if (!response.ok) {
          return Promise.reject(json);
        }
        return json;
      }
    } catch (error) {
      throw new Error("Có lỗi xảy ra trong quá trình lấy dữ liệu từ máy chủ. Vui lòng thử đăng nhập lại!");
    }
  } else {
    navigate("/login");
  }
};