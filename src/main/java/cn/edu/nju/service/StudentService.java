package cn.edu.nju.service;


import cn.edu.nju.entity.StudentEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lance on 2/12/16.
 */
public interface StudentService {

    public StudentEntity login(String uid, String password);
    public StudentEntity register(StudentEntity studentEntity);
    public boolean delete(String userId);
    public boolean update(StudentEntity studentEntity);
    public List<StudentEntity> findAll();
    public StudentEntity findById(String uid);
    public List<StudentEntity> getData(int page);
    public int getTotalPage();
}
