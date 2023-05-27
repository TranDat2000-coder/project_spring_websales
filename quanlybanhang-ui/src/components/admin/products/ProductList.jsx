
function ProductsList() {

    return (
        <div className="col-lg-12 grid-margin stretch-card">
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
                            <tr>
                                <td className="py-1"><p text=""></p></td>
                                <td><img src="" className="card img-fluid" width="50" height="50" alt="" /></td>
                                <td><p text=""></p> </td>
                                <td><p text=""></p></td>
                                <td>
                                    <a href="" title="Sửa" className="edit"><i className="fa fa-pencil-square-o" aria-hidden="true"></i></a>
                                    <a href="" title="Xóa"><i className="fa fa-trash" aria-hidden="true"></i></a>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    );
}

export default ProductsList;