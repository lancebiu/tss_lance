package cn.edu.nju.service;

import cn.edu.nju.entity.TeacherEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lance on 2/12/16.
 */
public interface TeacherService {
    public TeacherEntity login(String uid, String password);
    public TeacherEntity register(TeacherEntity teacherEntity);
    public boolean delete(String userId);
    public boolean update(TeacherEntity teacherEntity);
    public List<TeacherEntity> findAll();
    public TeacherEntity findById(String uid);
    public List<TeacherEntity> getData(int page);
    public int getTotalPage();
}
