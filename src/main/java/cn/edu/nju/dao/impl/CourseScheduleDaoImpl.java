package cn.edu.nju.dao.impl;

import cn.edu.nju.dao.CourseScheduleDao;
import cn.edu.nju.entity.CompleteCourseScheduleEntity;
import cn.edu.nju.entity.CourseScheduleEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by lance on 2/13/16.
 */
public class CourseScheduleDaoImpl implements CourseScheduleDao {

    public CourseScheduleEntity saveSchedule(CourseScheduleEntity courseScheduleEntity) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            session.saveOrUpdate(courseScheduleEntity);
            session.getTransaction().commit();
            return courseScheduleEntity;
        }catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }finally {
            session.close();
        }
    }

    public boolean deleteSchedule(CourseScheduleEntity courseScheduleEntity) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            session.delete(courseScheduleEntity);
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

    public boolean update(CourseScheduleEntity courseScheduleEntity) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            session.update(courseScheduleEntity);
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

    public List findAllSchedule(String term) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        String hql = "from CompleteCourseScheduleEntity where term = ? ";
        List list = session.createQuery(hql).setString(0, term).list();
        session.clear();

        return list;
    }

    public List findAllScheduleToBeAllocated(String term) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        String hql = "from CourseScheduleEntity where tid is null and term = ?";
        List list = session.createQuery(hql).setString(0, term).list();
        session.clear();

        return list;
    }

    public CourseScheduleEntity findById(int csid) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        String hql = "from CourseScheduleEntity where csid = ? ";
        List list = session.createQuery(hql)
                .setInteger(0, csid).list();
        if(list.size() > 0) {
            return (CourseScheduleEntity) list.get(0);
        }
        session.close();
        return null;
    }

    public CompleteCourseScheduleEntity findByCTT(String cid, String term, String tid) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        String hql = "from CompleteCourseScheduleEntity where cid = ? and term = ? and tid = ?";
        List list = session.createQuery(hql).setString(0, cid).setString(1, term).setString(2, tid).list();
        if (list.size() > 0) {
            return (CompleteCourseScheduleEntity) list.get(0);
        }
        session.close();
        return null;
    }

}
