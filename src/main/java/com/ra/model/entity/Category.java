package com.ra.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer categoryId;
    //nullable: ko để rỗng
    @Column(name = "name", length = 100, unique = true, nullable = false)
    private String categoryName;
    @Column(name = "status")
    private Boolean categoryStatus;

    //Khóa ngoại
    //Danh mục: 1
    //Sản phẩm: nhiều
    @OneToMany(mappedBy = "category")
    private Set<Product> products;

    //Constructor
    public Category() {
    }

    public Category(Integer categoryId, String categoryName, Boolean categoryStatus, Set<Product> products) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryStatus = categoryStatus;
        this.products = products;
    }

    //Getter, setter
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Boolean getCategoryStatus() {
        return categoryStatus;
    }

    public void setCategoryStatus(Boolean categoryStatus) {
        this.categoryStatus = categoryStatus;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}

