package cn.edu.nju.dao;

import cn.edu.nju.entity.CourseEntity;

import java.util.List;

/**
 * Created by lance on 2/13/16.
 */
public interface CourseDao {

    public List findAll();
    public CourseEntity findById(String cid);

}
