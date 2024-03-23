import React, { useEffect, useState } from "react";
import { Route, Router, Routes } from "react-router-dom";
import HomeAdmin from "./admin/HomeAdmin";
import Login from "./admin/Login";
import AuthService from "./service/auth-service";
import Products from "./admin/products/Products";


const AdminIndex = () => {

    const [currentUser, setCurrentUser] = useState(undefined);

    useEffect(() => {
        const user = AuthService.getCurrentUser();
        if (user) {
            setCurrentUser(user);
        }
    }, []);

    return (
        <div>

            <Routes>
                <Route path="/" element={currentUser ? <HomeAdmin /> : <Login />} />
                <Route path="home/*" element={currentUser ? <HomeAdmin /> : <Login />} />
                {/* <Route path="products" element={<Products />} /> */}

                <Route path="login" element={<Login />} />
            </Routes>

        </div>
    );
}

export default AdminIndex;