
import { request } from "../axios/axios";
import { API_BASE_ADMIN_URL } from "./constants";

export const _getProductListAPI = () => {
    return request({
        url: API_BASE_ADMIN_URL + "/danh-sach-san-pham",
        method: "GET",
        body: JSON.stringify()
    });
}


