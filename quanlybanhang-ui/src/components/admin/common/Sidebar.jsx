
import { Menu } from "antd";
import imageProfile from "../../../static/admin/images/faces/face8.jpg";

function Sidebar() {

    function getItem(label, key, children, type) {
        return {
            key,
            children,
            label,
            type,
        };
    }

    const items = [
        getItem("Quản lý sản phẩm", "sub1", [
            getItem(<a className="nav-link" href="/product-list">Danh sách sản phẩm</a>, "a1"),
            getItem(<a className="nav-link" href="">Thêm sách sản phẩm</a>, "a2")
        ]),
        getItem("Quản lý thể loại", "sub2", [
            getItem("Danh sách sản phẩm", "b1"),
            getItem("Thêm sách sản phẩm", "b2")
        ])
    ]

    const onClick = (e) => {
        console.log('click ', e);
    };

    return (
        <nav className="sidebar sidebar-offcanvas" id="sidebar">
            <ul className="nav">
                <li className="nav-item nav-profile">
                    <a href="#" className="nav-link">
                        <div className="profile-image">
                            <img className="img-xs rounded-circle" src={imageProfile} alt="profile image" />
                            <div className="dot-indicator bg-success"></div>
                        </div>
                        <div className="text-wrapper">
                            <p className="profile-name">Allen Moreno</p>
                            <p className="designation">Administrator</p>
                        </div>
                        <div className="icon-container">
                            <i className="icon-bubbles"></i>
                            <div className="dot-indicator bg-danger"></div>
                        </div>
                    </a>
                </li>
                <Menu
                    style={{
                        background: "none",
                        color: "white",
                        fontSize: "16px"
                    }}
                    onClick={onClick}
                    defaultSelectedKeys={['1']}
                    // defaultOpenKeys={['sub1']}
                    theme="dark"
                    mode="inline"
                    items={items}
                />
            </ul>
        </nav>
    );
}

export default Sidebar;