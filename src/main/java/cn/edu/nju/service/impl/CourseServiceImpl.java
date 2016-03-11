package cn.edu.nju.service.impl;

import cn.edu.nju.dao.CourseDao;
import cn.edu.nju.entity.CourseEntity;
import cn.edu.nju.service.CourseService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lance on 2/13/16.
 */
public class CourseServiceImpl implements CourseService {

    CourseDao dao;

    public void setDao(CourseDao dao) {
        this.dao = dao;
    }

    public List<CourseEntity> findAll() {
        List courses = dao.findAll();
        List<CourseEntity> list = new ArrayList<CourseEntity>();
        for (Object course: courses) {
            list.add((CourseEntity)course);
        }
        return list;
    }

    public CourseEntity findById(String cid) {
        return dao.findById(cid);
    }
}
