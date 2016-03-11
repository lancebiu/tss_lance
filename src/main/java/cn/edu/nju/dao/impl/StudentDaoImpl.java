package cn.edu.nju.dao.impl;

import cn.edu.nju.dao.StudentDao;
import cn.edu.nju.entity.StudentEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by lance on 2/12/16.
 */
public class StudentDaoImpl implements StudentDao {

    public StudentEntity checkUser(String uid, String password) {
        StudentEntity studentEntity = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        String hql = "from StudentEntity where uid = ? and password = ?";

        List list = session.createQuery(hql)
                .setString(0, uid).setString(1, password).list();

        if(list.size() > 0) {
            studentEntity = (StudentEntity) list.get(0);
        }
        session.close();

        return studentEntity;
    }

    public StudentEntity saveUser(StudentEntity studentEntity) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            session.saveOrUpdate(studentEntity);
            session.getTransaction().commit();
            return studentEntity;
        }catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }finally {
            session.close();
        }
    }

    public boolean deleteUser(StudentEntity studentEntity) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            session.delete(studentEntity);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
    }

    public boolean updateUser(StudentEntity studentEntity) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            session.update(studentEntity);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
    }

    public List findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        String hql = "from StudentEntity ";
        List list = session.createQuery(hql).list();
        session.clear();

        return list;
    }

    public StudentEntity findById(String uid) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        String hql = "from StudentEntity where uid = ?";
        List list = session.createQuery(hql)
                .setString(0, uid).list();
        if(list.size() > 0) {
            return (StudentEntity) list.get(0);
        }
        session.close();
        return null;
    }

    public List getData(int firstRow, int length) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        return session.createQuery("from StudentEntity").setFirstResult(firstRow).setMaxResults(length).list();
    }
}
