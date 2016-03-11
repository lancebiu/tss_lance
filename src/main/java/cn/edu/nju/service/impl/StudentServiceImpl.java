package cn.edu.nju.service.impl;

import cn.edu.nju.dao.StudentDao;
import cn.edu.nju.entity.StudentEntity;
import cn.edu.nju.service.StudentService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lance on 2/12/16.
 */
public class StudentServiceImpl implements StudentService {

    final int pageCols = 12;

    StudentDao dao;


    public void setDao(StudentDao dao) {
        this.dao = dao;
    }

    public StudentEntity login(String uid, String password) {
        return dao.checkUser(uid, password);
    }

    public StudentEntity register(StudentEntity studentEntity) {
        return dao.saveUser(studentEntity);
    }

    public boolean delete(String userId) {
        StudentEntity studentEntity = dao.findById(userId);
        return studentEntity != null && dao.deleteUser(studentEntity);

    }

    public boolean update(StudentEntity studentEntity) {
        return dao.updateUser(studentEntity);
    }

    public List<StudentEntity> findAll() {
        List students = dao.findAll();
        List<StudentEntity> list = new ArrayList<StudentEntity>();
        for(Object student: students) {
            list.add((StudentEntity)student);
        }
        return list;
    }

    public StudentEntity findById(String uid) {
        return dao.findById(uid);
    }

    public List<StudentEntity> getData(int page) {
        List students = dao.getData((page-1)*pageCols, pageCols);
        List<StudentEntity> list = new ArrayList<StudentEntity>();
        for (Object student : students) {
            list.add((StudentEntity) student);
        }
        return list;
    }

    public int getTotalPage() {
        List list = dao.findAll();
        if (list.size() == 0)
            return 1;
        return (list.size()-1) / pageCols + 1;
    }
}