package com.ra.model.dao.category;

import com.ra.model.entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryDAOImp implements CategoryDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Category> findAll() {
        Session session = sessionFactory.openSession();
        List<Category> categories = new ArrayList<>();
        try{
            categories = session.createQuery("from Category", Category.class).list();
        }catch (Exception exception){
            exception.printStackTrace();
        }finally {
            session.close();
        }
        return categories;
    }

    //Thêm mới
    @Override
    public Boolean create(Category category) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.save(category);
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
    public Category findById(Integer id) {
        Session session = sessionFactory.openSession();
        try{
            return session.get(Category.class, id);
        }catch (Exception exception){
            exception.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    //Cập nhật
    @Override
    public Boolean update(Category category) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.update(category);
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
