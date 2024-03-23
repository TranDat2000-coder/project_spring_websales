import React, { useState } from "react";


const HomeAdmin = () => {

    console.log("có vào đây không");
    const [content, setContent] = useState('Trần Đạt');

    return (
        <div className="container-scroller">
            <div className="container-fluid page-body-wrapper">
                {/* <Sidebar /> */}
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