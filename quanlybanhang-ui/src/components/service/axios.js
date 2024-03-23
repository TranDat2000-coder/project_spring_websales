
const authHeader = () => {
    const user = JSON.parse(localStorage.getItem('user'));
    if (user && user.token) {
        return { 'Content-Type': 'application/json', 'Authorization': 'Bearer '.concat(user.token) }; // for Spring Boot back-end
        // return { 'x-access-token': user.accessToken };       // for Node.js Express back-end
    } else {
        return {};
    }
}

const request = async (options) => {
    const user = JSON.parse(localStorage.getItem('user'));

    const authorizationToken = 'Bearer '.concat(user.token);
    const headers = { 'Content-Type': 'application/json', 'Authorization': authorizationToken };

    options.headers = headers;
    try {
        const response = await fetch(options.url, options);
        if (!response.ok && (response.status === 403 || response.status === 500)) {
            throw new Error('Phiên đăng nhập hết hạn');
        } else {
            const data = await response.json();
            if (!response.ok) {
                return Promise.reject(data);
            }
            return data;
        }
    } catch (error) {
        throw new Error('Có lỗi xảy ra trong quá trình lấy dữ liệu từ máy chủ. Vui lòng thử đăng nhập lại!')
    }
}

const requestImage = async (options) => {
    const user = JSON.parse(localStorage.getItem('user'));

    const authorizationToken = 'Bearer '.concat(user.token);
    const headers = { 'Authorization': authorizationToken };

    options.headers = headers;
    try {
        debugger
        const response = await fetch(options.url, options);
        if (!response.ok && (response.status === 403 || response.status === 500)) {
            throw new Error('Phiên đăng nhập hết hạn');
        } else {

            return response;
        }
    } catch (error) {
        throw new Error('Có lỗi xảy ra trong quá trình lấy dữ liệu từ máy chủ. Vui lòng thử đăng nhập lại!')
    }
}

const AxiosConnect = {
    request,
    authHeader,
    requestImage
}

export default AxiosConnect;
