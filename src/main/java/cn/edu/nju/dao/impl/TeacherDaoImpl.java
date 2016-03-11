package cn.edu.nju.dao.impl;

import cn.edu.nju.dao.TeacherDao;
import cn.edu.nju.entity.TeacherEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lance on 2/12/16.
 */
public class TeacherDaoImpl implements TeacherDao {

    public TeacherEntity checkUser(String uid, String password) {
        TeacherEntity teacherEntity = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        String hql = "from TeacherEntity where tid = ? and password = ?";

        List list = session.createQuery(hql)
                .setString(0, uid).setString(1, password).list();

        if(list.size() > 0) {
            teacherEntity = (TeacherEntity) list.get(0);
        }
        session.close();

        return teacherEntity;
    }

    public TeacherEntity saveUser(TeacherEntity teacherEntity) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            session.saveOrUpdate(teacherEntity);
            session.getTransaction().commit();
            return teacherEntity;
        }catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }finally {
            session.close();
        }
    }

    public boolean deleteUser(TeacherEntity teacherEntity) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            session.delete(teacherEntity);
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

    public boolean updateUser(TeacherEntity teacherEntity) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            session.update(teacherEntity);
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

        String hql = "from TeacherEntity ";
        List list = session.createQuery(hql).list();
        session.clear();

        return list;
    }

    public TeacherEntity findById(String tid) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        String hql = "from TeacherEntity where tid = ?";
        List list = session.createQuery(hql)
                .setString(0, tid).list();
        if(list.size() > 0) {
            return (TeacherEntity) list.get(0);
        }
        session.close();
        return null;
    }

    public List getData(int firstRow, int length) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        return session.createQuery("from TeacherEntity ").setFirstResult(firstRow).setMaxResults(length).list();
    }
}
