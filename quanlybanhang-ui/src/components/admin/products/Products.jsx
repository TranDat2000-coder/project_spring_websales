import React, { useState, useEffect, useMemo } from "react";
import { useNavigate } from 'react-router-dom';
import { notification } from 'antd';
import { fetchProductAPI, fetchShowImage } from '../../service/product-service';
import AuthService from "../../service/auth-service";

const API_URL = 'http://localhost:8082/admin';

const Products = () => {

    let navigate = useNavigate();

    const [api, contextHolder] = notification.useNotification();
    const [dataProducts, setData] = useState([]);
    const [image, setImage] = useState(null);

    useEffect(() => {
        loadDataProduct()
    }, []);

    const openNotification = (placement) => {
        api.info({
            message: `Phiên đăng nhập hết hạn`,
            placement,
        });
    };



    const loadDataProduct = () => {
        const formData = {
            pageNo: "1",
            pageSize: "2"
        }
        fetchProductAPI(formData).then((res) => {
            const newProductData = [];
            console.log("data: ", res);

            for (let i = 0; i < res.data.length; i++) {
                // fetchShowImage(res.data[i].id).then(data => {

                newProductData.push({
                    key: i + 1,
                    name: res.data[i].namePhone,
                    picture: <img src={API_URL + `/image/display/${res.data[i].id}`} />,
                    // picture: <img src={image} />,
                    priceSale: res.data[i].priceSale,
                    price: res.data[i].price
                })
                // });
            }
            setData(newProductData)
        }).catch((err) => {
            openNotification('topRight');
            setTimeout(() => {
                navigate("/admin/login");
            }, 2800);
            AuthService.logout();
            console.log("err: ", err);
        })
    }

    console.log("dataProducts: ", dataProducts);

    return (
        <div className="col-lg-12 grid-margin stretch-card">
            {contextHolder}
            <div className="card">
                <div className="card-body">
                    <h4 className="card-title">Striped Table</h4>
                    <p className="card-description"> Add class <code>.table-striped</code></p>
                    <a href="">Thêm sản phẩm</a>
                    <table className="table table-striped">
                        <thead>
                            <tr>
                                <th> Tên sản phẩm </th>
                                <th> Ảnh </th>
                                <th> pricesale </th>
                                <th> Price </th>
                                <th> Thao tác </th>
                            </tr>
                        </thead>
                        <tbody>
                            {dataProducts.map((item, index) => (
                                <tr key={index}>
                                    <td className="py-1"><p text="">{item.name}</p></td>
                                    <td>{item.picture}</td>
                                    <td><p text="">{item.priceSale}</p> </td>
                                    <td><p text="">{item.price}</p></td>
                                    <td>
                                        <a href="" title="Sửa" className="edit"><i className="fa fa-pencil-square-o" aria-hidden="true"></i></a>
                                        <a href="" title="Xóa"><i className="fa fa-trash" aria-hidden="true"></i></a>
                                    </td>

                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    );
}

export default Products;