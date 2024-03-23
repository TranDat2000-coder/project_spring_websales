
import React, { useState, useRef } from 'react';
import { useNavigate } from 'react-router-dom';
import AuthService from '../service/auth-service';
import '../../static/admin/css/style.css';
import { LockOutlined, UserOutlined } from '@ant-design/icons';
import { Button, Checkbox, Form, Input } from 'antd';

const Login = () => {

    let navigate = useNavigate();

    const form = useRef();
    const checkBtn = useRef();

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [loading, setLoading] = useState(false);
    const [message, setMessage] = useState('');

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
            navigate('/admin/home');
            window.location.reload();
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

        <div className='form-login' >
            <div className='bg-login'>
                <div className='wrapper-form'>
                    <div className='header'><h3>Đăng nhập</h3></div>
                    <div className='content-form'>
                        <Form name='normal_login'
                            className='login-form'
                            initialValues={{
                                remember: true,
                            }}>
                            <Form.Item name='username'
                                rules={[
                                    {
                                        required: true,
                                        message: 'Please input your Username!',
                                    },
                                ]}>
                                <Input
                                    prefix={<UserOutlined className='site-form-item-icon' />}
                                    placeholder='Username'
                                    value={username}
                                    onChange={onChangeUsername} />
                            </Form.Item>
                            <Form.Item name='password'
                                rules={[
                                    {
                                        required: true,
                                        message: 'Please input your Password!',
                                    },
                                ]}>
                                <Input
                                    prefix={<LockOutlined className='site-form-item-icon' />}
                                    type='password'
                                    placeholder='Password'
                                    value={password}
                                    onChange={onChangePassword} />
                            </Form.Item>
                            <Form.Item>
                                <Form.Item name='remember' valuePropName='checked' noStyle>
                                    <Checkbox>Remember me</Checkbox>
                                </Form.Item>
                                <a className='login-form-forgot' href=''> Forgot password </a>
                            </Form.Item>
                            <Form.Item>
                                <Button type='primary' htmlType='submit' className='login-form-button' onClick={handleLogin}>
                                    Log in
                                </Button>
                                Or <a href=''>register now!</a>
                            </Form.Item>
                        </Form>
                    </div>
                </div>
            </div>
        </div>

    );
}

export default Login;