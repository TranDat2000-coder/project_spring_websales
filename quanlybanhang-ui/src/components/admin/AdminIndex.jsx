import Navbar from "./common/Navbar";
import '../../static/admin/css/style.css';
import '../../static/admin/vendors/simple-line-icons/css/simple-line-icons.css';
import '../../static/admin/font-awesome/css/font-awesome.min.css';
import '../../static/admin/vendors/css/vendor.bundle.base.css';
// import '../../static/admin/vendors/js/vendor.bundle.base';

import Sidebar from "./common/Sidebar";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import ProductsList from "./products/ProductList";

function Admin_index() {

    return (
        <div className="container-scroller">
            <Navbar />
            <div className="container-fluid page-body-wrapper">
                <Sidebar />
                <div className="main-panel">
                    <div className="content-wrapper">
                        <div className="row">
                            <BrowserRouter>
                                <Routes>
                                    <Route path="/product-list" element={<ProductsList />}></Route>
                                </Routes>
                            </BrowserRouter>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Admin_index;