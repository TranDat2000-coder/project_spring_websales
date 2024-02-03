
import '../../static/admin/css/style.css';
import '../../static/admin/vendors/simple-line-icons/css/simple-line-icons.css';
import '../../static/admin/font-awesome/css/font-awesome.min.css';
import '../../static/admin/vendors/css/vendor.bundle.base.css';
import React, { useEffect, useState } from "react";
import Navbar from "./common/Navbar";
import Sidebar from "./common/Sidebar";


const HomeAdmin = () => {

    console.log("có vào đây không");
    const [content, useContent] = useState("Trần Đạt");

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
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default HomeAdmin;