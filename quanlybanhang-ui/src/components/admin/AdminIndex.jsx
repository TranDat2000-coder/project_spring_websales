import { useEffect, useState } from "react";
import Navbar from "./common/Navbar";
import '../../static/admin/css/style.css';
import '../../static/admin/vendors/simple-line-icons/css/simple-line-icons.css';
import '../../static/admin/font-awesome/css/font-awesome.min.css';
import '../../static/admin/vendors/css/vendor.bundle.base.css';
import UserService from '../../services/user.service';

import Sidebar from "./common/Sidebar";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import ProductsList from "./products/ProductList";


function Admin_index() {

    const [content, setContent] = useState("");
    useEffect(() => {
        UserService.getPublicContent().then(response => {
            console.log("response", response);
            setContent(response.data);
        },
            (error) => {
                const _content =
                    (error.response && error.response.data) ||
                    error.message ||
                    error.toString();

                setContent(_content);
            }
        );
    }, []);

    return (
        <div className="container-scroller">
            <Navbar />
            <div className="container-fluid page-body-wrapper">
                <Sidebar />
                <div className="main-panel">
                    <div className="content-wrapper">
                        <div className="row">
                            <header className="jumbotron">
                                <h3>{content}</h3>
                            </header>
                            {/* <BrowserRouter>
                                <Routes>
                                    <Route path="/product-list" element={<ProductsList />}></Route>
                                </Routes>
                            </BrowserRouter> */}
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Admin_index;