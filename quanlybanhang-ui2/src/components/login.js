import React, { useEffect, useState } from 'react';
import Form from "react-validation/build/form";
import Input from "react-validation/build/input";
import CheckButton from "react-validation/build/button";
import AuthService from '../utils/action_login';


function Login() {



    const [loading, setLoading] = useState(false);
    const [message, setMessage] = useState('');
    const [username, setUsername] = useState();
    const [password, setPassword] = useState();

    useEffect(() => {
    });

    const handleValueUsername = e => {
        setUsername(e.target.value);
    }
    const handleValuePassword = e => {
        setPassword(e.target.value);
    }

    const handleLogin = (e) => {

    }

    return (
        <div className="col-md-12">
            <div className="card card-container">
                <Form
                    onSubmit={handleLogin}
                    ref={c => {
                        this.form = c;
                    }}
                >
                    <div className='form-group'>
                        <label htmlFor='username'>Username</label>
                        <Input
                            type='text'
                            className="form-control"
                            name="username"
                            value={username}
                            onChange={handleValueUsername}

                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="password">Password</label>
                        <Input
                            type="password"
                            className="form-control"
                            name="password"
                            value={password}
                            onChange={handleValuePassword}

                        />
                    </div>
                    <div className="form-group">
                        <button
                            className="btn btn-primary btn-block"
                            disabled={loading}
                        >
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
                </Form>
            </div>
        </div>
    );
}

export default Login;