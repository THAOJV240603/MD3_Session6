<!--Ánh xạ toàn bộ thông tin của form vào form Thêm mới-->
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: thao
  Date: 10/11/2024
  Time: 8:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Thêm mới sản phẩm</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-6">
            <!--f:form: Ánh xạ toàn bộ thông tin của form vào form Thêm mới-->
            <!--modelAttribute="product": tương ứng 1 đối tượng product chuyển từ controller sang-->
            <!--Muốn upload file thì thẻ form phải có thêm thuộc tính enctype="multipart/form-data"-->
            <f:form method="post" action="" modelAttribute="product" enctype="multipart/form-data">
                <div class="form-group">
                    <label>Product name</label>
                    <f:input type="text" class="form-control" path="productName"/>
                </div>

                <div class="form-group">
                    <label>Price</label>
                    <f:input type="text" class="form-control" path="price"/>
                </div>

                <div class="form-group">
                    <label>Image</label>
                    <input type="file" class="form-control" />
                </div>

                <div class="form-group">
                    <label>Chọn danh mục</label>
                    <f:select class="form-control" path="category.categoryId">
                        <option>Tên danh mục</option>
                        <f:options items="${categories}" itemLabel="categoryName" itemValue="categoryId"/>
                    </f:select>
                </div>

                <button type="submit" class="btn btn-primary">Thêm mới</button>
            </f:form>
        </div>
    </div>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>