package com.ra.model.service.product;

import com.ra.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    //Thêm mới
    Boolean create(Product product);

    //Muốn sửa thì phải có findById
    Product findById(Integer id);
    //Sửa
    Boolean update(Product product);

    //Xóa (xóa theo id)
    void delete(Integer id);
}
