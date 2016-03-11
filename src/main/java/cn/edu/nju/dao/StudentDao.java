package cn.edu.nju.dao;

import cn.edu.nju.entity.StudentEntity;

import java.util.List;

/**
 * Created by lance on 2/12/16.
 */
public interface StudentDao {
    public StudentEntity checkUser(String uid, String password);
    public StudentEntity saveUser(StudentEntity studentEntity);
    public boolean deleteUser(StudentEntity studentEntity);
    public boolean updateUser(StudentEntity studentEntity);
    public List findAll();
    public StudentEntity findById(String uid);
    public List getData(int firstRow, int length);
}
