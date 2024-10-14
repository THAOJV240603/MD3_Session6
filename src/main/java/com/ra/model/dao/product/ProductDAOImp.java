package com.ra.model.dao.product;

import com.ra.model.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDAOImp implements ProductDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Product> findAll(){
        Session session = sessionFactory.openSession();
        List<Product> products= new ArrayList<>();
        try{
            products = session.createQuery("from Product ", Product.class).list();
        }catch (Exception exception){
            exception.printStackTrace();
        }finally {
            session.close();
        }
        return products;
    }

    //Thêm mới
    @Override
    public Boolean create(Product product) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
            return true;
        }catch (Exception exception){
            exception.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public Product findById(Integer id) {
        Session session = sessionFactory.openSession();
        try{
            return session.get(Product.class, id);
        }catch (Exception exception){
            exception.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    //Cập nhật
    @Override
    public Boolean update(Product product) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.update(product);
            session.getTransaction().commit();
            return true;
        }catch (Exception exception){
            exception.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return null;
    }

    //Xóa
    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.delete(findById(id));
            session.getTransaction().commit();
        }catch (Exception exception){
            exception.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
    }
}
