package com.ra.model.dao.category;

import com.ra.model.entity.Category;

import java.util.List;

public interface CategoryDAO {
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
