package com.ra.model.service.category;

import com.ra.model.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    //Thêm mới
    Boolean create(Category category);

    //Muốn sửa thì phải có findById
    Category findById(Integer id);
    //Sửa
    Boolean update(Category category);

    //Xóa (xóa theo id)
    void delete(Integer id);
}
