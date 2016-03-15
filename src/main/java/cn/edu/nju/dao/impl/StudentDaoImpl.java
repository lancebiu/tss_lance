package cn.edu.nju.dao.impl;

import cn.edu.nju.dao.StudentDao;
import cn.edu.nju.entity.*;
import org.hibernate.Query;
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

    public CourseSelectionEntity selectCourse(CourseSelectionEntity courseSelectionEntity) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            session.saveOrUpdate(courseSelectionEntity);
            session.getTransaction().commit();
            return courseSelectionEntity;
        }catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }finally {
            session.close();
        }
    }

    public List<CompleteSelectedCourseEntity> findMyCourse(String uid, String term) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        String hql = "from CompleteSelectedCourseEntity where uid = ? and term = ?";
        List list = session.createQuery(hql).setString(0, uid).setString(1, term).list();
        if(list.size() > 0) {
            return list;
        }
        session.close();
        return null;
    }

    public boolean deleteCourse(CourseSelectionEntity courseSelectionEntity) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            session.delete(courseSelectionEntity);
            session.getTransaction().commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }finally {
            session.close();
        }
    }

    public List<CourseSelectionEntity> findMySelectedCourse(String uid) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        String hql = "from CourseSelectionEntity where uid = ?";
        List list = session.createQuery(hql).setString(0, uid).list();
        if (list.size() > 0) {
            return list;
        }
        session.close();
        return null;
    }

    public StudentHomeworkEntity findHomeworkById(int shid) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        String hql = "from StudentHomeworkEntity where shid = ?";
        List list = session.createQuery(hql).setInteger(0, shid).list();
        if (list.size() > 0) {
            return (StudentHomeworkEntity) list.get(0);
        }
        session.close();
        return null;
    }

    public StudentHomeworkEntity findHomeworkById(int hid, String uid) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        String hql = "from StudentHomeworkEntity where hid = ? and uid = ?";
        List list = session.createQuery(hql).setInteger(0, hid).setString(1, uid).list();
        if (list.size() > 0) {
            return (StudentHomeworkEntity) list.get(0);
        }
        session.close();
        return null;
    }

    public List<DesHomeworkEntity> findHomework(String uid, int csid) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        String hql = "from DesHomeworkEntity where uid = ? and csid = ?";
        List list = session.createQuery(hql).setString(0, uid).setInteger(1, csid).list();
        if (list.size() > 0) {
            return list;
        }
        session.close();
        return null;
    }

    public HomeworkFileEntity uploadHomework(HomeworkFileEntity homeworkFileEntity) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            session.saveOrUpdate(homeworkFileEntity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        session = sessionFactory.openSession();

        String hql = "from HomeworkFileEntity where fname = ?";
        List list = session.createQuery(hql).setString(0, homeworkFileEntity.getFname()).list();
        if (list.size() > 0) {
            return (HomeworkFileEntity) list.get(list.size() - 1);
        }
        session.close();
        return null;
    }

    public StudentHomeworkEntity uploadStuHomework(StudentHomeworkEntity studentHomeworkEntity) {
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

    public List<AssistantEntity> findAllAs() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        String hql = "from AssistantEntity";
        List list = session.createQuery(hql).list();
        session.clear();

        return list;
    }

    public List<AssistCourseEntity> findAsCourse(String uid) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        String hql = "from AssistCourseEntity where uid = ?";
        List list = session.createQuery(hql).setString(0, uid).list();
        if (list.size() > 0) {
            return list;
        }
        session.close();
        return null;
    }

    public List<CompleteHomeworkEntity> findStuHomework(int csid) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        String hql = "from CompleteHomeworkEntity where csid = ? and (status = 0 or status = 3)";
        List list = session.createQuery(hql).setInteger(0, csid).list();
        if (list.size() > 0) {
            return list;
        }
        session.close();
        return null;
    }

    public boolean examHomework(StudentHomeworkEntity studentHomeworkEntity) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            session.update(studentHomeworkEntity);
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
}
