package com.ra.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer productId;
    @Column(name = "name", length = 100, unique = true, nullable = false)
    public String productName;
    @Column(name = "price")
    public Double price;
    @Column(name = "image")
    public String image;
    //Khóa ngoại
    //Sản phẩm: nhiều
    //Danh mục: 1
    @ManyToOne
    //name = "<tên_khóa_ngoại>"
    //referencedColumnName = "<khóa_ngoại_tham_chiếu_đến_bảng_categories>"
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    //Biến category phải giống vs trường mappedBy = "category" ở Class Category
    private Category category;
    //Constructor
    public Product() {
    }

    public Product(Integer productId, String productName, Double price, String image, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.image = image;
        this.category = category;
    }

    //Getter, setter
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
