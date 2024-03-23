
import React from 'react';

import { Menu } from 'antd';
import imageProfile from '../../../static/admin/images/faces/face8.jpg';
import { Link } from 'react-router-dom';

const Sidebar = () => {

    function getItem(label, key, children, type) {
        return {
            key,
            children,
            label,
            type,
        };
    }

    const items = [
        getItem('Quản lý thể loại', 'menu2', [
            getItem(<a className='nav-link' href=''>Thêm thể loại</a>, 'b2'),
            getItem(<Link className='nav-link' to='/admin/home/category'>Danh sách thể loại</Link>, 'b1')
        ]),
        getItem('Quản lý sản phẩm', 'menu1', [
            getItem(<a className='nav-link' href=''>Thêm sản phẩm</a>, 'a1'),
            getItem(<Link to='/admin/home/products' className='nav-link'>Danh sách sản phẩm</Link>, 'a2')
        ])
    ]

    const onClick = (e) => {

    };

    return (
        <nav className='sidebar sidebar-offcanvas' id='sidebar'>
            <ul className='nav'>
                <li className='nav-item nav-profile'>
                    <a href='#' className='nav-link'>
                        <div className='profile-image'>
                            <img className='img-xs rounded-circle' src={imageProfile} alt='profile image' />
                            <div className='dot-indicator bg-success'></div>
                        </div>
                        <div className='text-wrapper'>
                            <p className='profile-name'>Allen Moreno</p>
                            <p className='designation'>Administrator</p>
                        </div>
                        <div className='icon-container'>
                            <i className='icon-bubbles'></i>
                            <div className='dot-indicator bg-danger'></div>
                        </div>
                    </a>
                </li>
                <Menu
                    style={{
                        background: 'none',
                        color: 'white',
                        fontSize: '16px'
                    }}
                    onClick={onClick}
                    defaultSelectedKeys={['1']}
                    // defaultOpenKeys={['sub1']}
                    theme='dark'
                    mode='inline'
                    items={items}
                />
            </ul>
        </nav>
    );
}

export default Sidebar;