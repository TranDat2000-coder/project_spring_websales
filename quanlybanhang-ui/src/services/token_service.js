
const getLocalRefreshToken = () => {
    const user = JSON.parse(localStorage.getItem("user"));
    return user?.refreshToken;
};

const setUser = (user) => {
    localStorage.setItem("user", JSON.stringify(user));
}

const removeUser = () => {
    localStorage.removeItem("user");
}

const TokenService = {
    getLocalRefreshToken,
    setUser,
    removeUser
}

export default TokenService;
