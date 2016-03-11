package cn.edu.nju.dao.impl;

import cn.edu.nju.dao.CourseDao;
import cn.edu.nju.entity.CourseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by lance on 2/13/16.
 */
public class CourseDaoImpl implements CourseDao {

    public List findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        String hql = "from CourseEntity ";
        List list = session.createQuery(hql).list();
        session.clear();

        return list;
    }

    public CourseEntity findById(String cid) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        String hql = "from CourseEntity where cid = ?";
        List list = session.createQuery(hql)
                .setString(0, cid).list();
        if(list.size() > 0) {
            return (CourseEntity) list.get(0);
        }
        session.close();
        return null;
    }
}
