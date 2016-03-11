package cn.edu.nju.dao;

import cn.edu.nju.entity.TeacherEntity;

import java.util.List;

/**
 * Created by lance on 2/12/16.
 */
public interface TeacherDao {
    
    public TeacherEntity checkUser(String uid, String password);
    public TeacherEntity saveUser(TeacherEntity teacherEntity);
    public boolean deleteUser(TeacherEntity teacherEntity);
    public boolean updateUser(TeacherEntity teacherEntity);
    public List findAll();
    public TeacherEntity findById(String uid);
    public List getData(int firstRow, int length);
}
