
export async function request(options) {
    const headers = { "Content-Type": 'application/json' };
    options.headers = headers;
    try {
        const response = await fetch(options.url, options);

        const json = await response.json();
        if (!response.ok) {
            return Promise.reject(json);
        } return json;

    } catch (error) {
        throw new Error("Có lỗi xảy ra trong quá trình lấy dữ liệu từ máy chủ. Vui lòng thử đăng nhập lại!");
    }
};