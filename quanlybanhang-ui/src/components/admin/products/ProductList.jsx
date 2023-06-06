import { Image, Table } from "antd";
import { useEffect, useState } from "react";
import { API_BASE_ADMIN_URL } from "../../../utils/constants";
import {
    _getProductListAPI
} from "../../../utils/actions";

function ProductsList() {

    const [selectedRowKeys, setSelectedRowKeys] = useState([]);

    const onSelectChange = (newSelectedRowKeys) => {
        console.log('selectedRowKeys changed: ', newSelectedRowKeys);
        setSelectedRowKeys(newSelectedRowKeys);
    };

    const [data, setData] = useState([]);

    useEffect(() => {
        loadData();
    });

    const loadData = () => {
        _getProductListAPI().then(res => {
            const newData = [];
            for (let i = 0; i < res.data.length; i++) {
                newData.push({
                    key: i + 1,
                    name: res.data[i].namePhone,
                    picture: <img src={API_BASE_ADMIN_URL + `/image/display/${res.data[i].id}`} />,
                    priceSale: res.data[i].priceSale,
                    price: res.data[i].price
                })
            }
            setData(newData);
        })
    }

    const columns = [
        {
            title: "Tên sản phẩm",
            dataIndex: "name",
        },
        {
            title: "Ảnh",
            dataIndex: "picture",
        },
        {
            title: " Giá Sale ",
            dataIndex: "priceSale",
        },
        {
            title: " Giá gốc ",
            dataIndex: "price",
        },
        {
            title: " Thao tác ",
            dataIndex: "action",
            render: () => {
                return (
                    <>
                        <a href="" title="Sửa" className="edit"><i className="fa fa-pencil-square-o" aria-hidden="true"></i></a>
                        <a href="" title="Xóa"><i className="fa fa-trash" aria-hidden="true"></i></a>
                    </>
                )
            }
        },
    ];

    const rowSelection = {
        selectedRowKeys,
        onChange: onSelectChange,
        selections: [
            Table.SELECTION_ALL,
            Table.SELECTION_INVERT,
            Table.SELECTION_NONE,
            {
                key: 'odd',
                text: 'Select Odd Row',
                onSelect: (changeableRowKeys) => {
                    let newSelectedRowKeys = [];
                    newSelectedRowKeys = changeableRowKeys.filter((_, index) => {
                        if (index % 2 !== 0) {
                            return false;
                        }
                        return true;
                    });
                    setSelectedRowKeys(newSelectedRowKeys);
                },
            },
            {
                key: 'even',
                text: 'Select Even Row',
                onSelect: (changeableRowKeys) => {
                    let newSelectedRowKeys = [];
                    newSelectedRowKeys = changeableRowKeys.filter((_, index) => {
                        if (index % 2 !== 0) {
                            return true;
                        }
                        return false;
                    });
                    setSelectedRowKeys(newSelectedRowKeys);
                },
            },
        ],
    };


    return (
        <div className="col-lg-12 grid-margin stretch-card">
            <div className="card">
                <div className="card-body">
                    <h4 className="card-title">Striped Table</h4>
                    <p className="card-description"> Add class <code>.table-striped</code></p>

                    <Table
                        className="table table-striped"
                        rowSelection={rowSelection}
                        columns={columns}
                        dataSource={data}
                    />
                </div>
            </div>
        </div>
    );
}

export default ProductsList;