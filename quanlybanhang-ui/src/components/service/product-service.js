
import axios from 'axios';
import AxiosConnect from './axios';
import authHeader, { request } from './axios';

const API_URL = 'http://localhost:8082/admin';

export const fetchProductAPI = (formData) => {

    return AxiosConnect.request({
        url: API_URL + '/list-products',
        method: 'POST',
        body: JSON.stringify(formData)
    });
}

// export const fetchShowImage = (id) => {
//     return AxiosConnect.requestImage({
//         url: API_URL + '/image/display/' + id,
//         method: 'GET',
//     });
// }

export const fetchShowImage = async (id) => {
    const user = JSON.parse(localStorage.getItem('user'));
    return fetch(API_URL + '/image/display/' + id, {
        headers: {
            Authorization: 'Bearer ' + user.token
        }
    }).then(response => response.blob());
}

// export const getPublicContent = (formData) => {
//     const user = JSON.parse(localStorage.getItem('user'));
//     console.log('user user: ', user);
//     return axios.post('http://localhost:8082/admin/list-products', formData,
//         {
//             headers: {
//                 Authorization: 'Bearer ' + user.token,
//                 'Content-Type': 'application/json'
//             }
//         })
// }