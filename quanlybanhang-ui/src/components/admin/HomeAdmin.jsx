
import React from "react";
import { Route, Routes } from 'react-router-dom';
import Sidebar from "./common/Sidebar";
import Navbar from "./common/Navbar";
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/scss/bootstrap.scss';
import '../../static/admin/css/style.css';
import '../../static/admin/vendors/simple-line-icons/css/simple-line-icons.css';
import '../../static/admin/font-awesome/css/font-awesome.min.css';
import '../../static/admin/vendors/css/vendor.bundle.base.css';
import Products from "./products/Products";
import Category from "./category/Category";

const HomeAdmin = () => {



    return (
        <div className="container-scroller">
            <Navbar />
            <div className="container-fluid page-body-wrapper">
                <Sidebar />
                <div className="main-panel">
                    <div className="content-wrapper">
                        <div className="row">
                            <Routes>
                                <Route path="products" element={<Products />} />
                                <Route path="category" element={<Category />} />
                            </Routes>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default HomeAdmin;