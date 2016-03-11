package cn.edu.nju.service;

import cn.edu.nju.entity.CourseEntity;

import java.util.List;

/**
 * Created by lance on 2/13/16.
 */
public interface CourseService {

    public List<CourseEntity> findAll();
    public CourseEntity findById(String cid);

}
