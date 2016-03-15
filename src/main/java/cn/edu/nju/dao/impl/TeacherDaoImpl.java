package cn.edu.nju.dao.impl;

import cn.edu.nju.dao.TeacherDao;
import cn.edu.nju.entity.*;
import com.sun.javafx.collections.ListListenerHelper;
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

    public List<CompleteCourseScheduleEntity> findCourse(String tid, String term) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        String hql = "from CompleteCourseScheduleEntity where tid = ? and term = ?";
        List list = session.createQuery(hql).setString(0, tid).setString(1, term).list();
        if(list.size() > 0) {
            return list;
        }
        session.close();
        return null;
    }

    public List<CompleteSelectedCourseEntity> findSelCourse(int csid) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        String hql = "from CompleteSelectedCourseEntity where csid = ?";
        List list = session.createQuery(hql).setInteger(0, csid).list();
        if(list.size() > 0) {
            return list;
        }
        session.close();
        return null;
    }

    public List<HomeworkEntity> findHomework(int csid) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        String hql = "from HomeworkEntity where csid = ?";
        List list = session.createQuery(hql).setInteger(0, csid).list();
        if(list.size() > 0) {
            return list;
        }
        session.close();
        return null;
    }

    public HomeworkEntity findHomeworkById(int hid) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        String hql = "from HomeworkEntity where hid = ?";
        List list = session.createQuery(hql).setInteger(0, hid).list();
        if(list.size() > 0) {
            return (HomeworkEntity) list.get(0);
        }
        session.close();
        return null;
    }

    public List<CompleteHomeworkEntity> findStuHomework(int csid, int hid) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        String hql = "from CompleteHomeworkEntity where csid = ? and hid = ?";
        List list = session.createQuery(hql).setInteger(0, csid).setInteger(1, hid).list();
        if(list.size() > 0) {
            return list;
        }
        session.close();
        return null;
    }

    public HomeworkEntity publishHomework(HomeworkEntity homeworkEntity) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            session.saveOrUpdate(homeworkEntity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        session = sessionFactory.openSession();
        String hql = "from HomeworkEntity where csid = ? and deadline = ? and description = ?";
        List list = session.createQuery(hql).setInteger(0, homeworkEntity.getCsid()).setString(1, homeworkEntity.getDeadline())
                .setString(2, homeworkEntity.getDescription()).list();
        if (list.size()>0){
            return (HomeworkEntity)list.get(0);
        }
        session.close();
        return null;
    }

    public ExampleFileEntity uploadExample(ExampleFileEntity exampleFileEntity) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            session.saveOrUpdate(exampleFileEntity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        session = sessionFactory.openSession();
        String hql = "from ExampleFileEntity where efname = ?";
        List list = session.createQuery(hql).setString(0, exampleFileEntity.getEfname()).list();
        if (list.size()>0){
            return (ExampleFileEntity) list.get(list.size()-1);
        }
        session.close();
        return null;
    }

    public StudentHomeworkEntity pulishStuHomework(StudentHomeworkEntity studentHomeworkEntity) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            session.saveOrUpdate(studentHomeworkEntity);
            session.getTransaction().commit();
            return studentHomeworkEntity;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public boolean arrangeAssistant(AssistantEntity assistantEntity) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            session.saveOrUpdate(assistantEntity);
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

    public List<AssistCourseEntity> findAss(int csid) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        String hql = "from AssistCourseEntity where csid = ?";
        List list = session.createQuery(hql).setInteger(0, csid).list();
        if(list.size() > 0) {
            return list;
        }
        session.close();
        return null;
    }
}
