
import React, { useState, useRef } from "react";
import "../assets/style.css";
import AuthService from "../services/auth_service";
import { useNavigate } from 'react-router-dom';
import Form from "react-validation/build/form";
import Input from "react-validation/build/input";
import CheckButton from "react-validation/build/button";

const Login = () => {

    let navigate = useNavigate();

    const form = useRef();
    const checkBtn = useRef();

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [loading, setLoading] = useState(false);
    const [message, setMessage] = useState("");

    const onChangeUsername = (e) => {
        const username = e.target.value;
        setUsername(username);
    }

    const onChangePassword = (e) => {
        const password = e.target.value;
        setPassword(password);
    };

    const onFinish = (values) => {
        console.log('Success:', values);
    };
    const onFinishFailed = (errorInfo) => {
        console.log('Failed:', errorInfo);
    };

    const handleLogin = async (e) => {
        e.preventDefault();
        AuthService.login(username, password).then((res) => {
            navigate("/home");
            // window.location.reload();
        }, (error) => {
            const message = (
                error.response &&
                error.response.data &&
                error.response.data.message) ||
                error.message ||
                error.toString();
            setMessage(message);
        })
    }

    return (
        <div className="container">
            <div className="row">

                <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12">
                    <div style={{ textAlign: "center" }}>
                        <h1>ĐĂNG NHẬP</h1>
                        <Form onSubmit={handleLogin} ref={form}>
                            <div className="form-group">
                                <label htmlFor="username">Username</label>
                                <Input
                                    type="text"
                                    className="form-control"
                                    name="username"
                                    value={username}
                                    onChange={onChangeUsername}

                                />
                            </div>

                            <div className="form-group">
                                <label htmlFor="password">Password</label>
                                <Input
                                    type="password"
                                    className="form-control"
                                    name="password"
                                    value={password}
                                    onChange={onChangePassword}

                                />
                            </div>

                            <div className="form-group">
                                <button className="btn btn-primary btn-block" disabled={loading}>
                                    {loading && (
                                        <span className="spinner-border spinner-border-sm"></span>
                                    )}
                                    <span>Login</span>
                                </button>
                            </div>

                            {message && (
                                <div className="form-group">
                                    <div className="alert alert-danger" role="alert">
                                        {message}
                                    </div>
                                </div>
                            )}
                            <CheckButton style={{ display: "none" }} ref={checkBtn} />
                        </Form>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Login;