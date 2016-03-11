package cn.edu.nju.service.impl;

import cn.edu.nju.dao.TeacherDao;
import cn.edu.nju.entity.TeacherEntity;
import cn.edu.nju.service.TeacherService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lance on 2/12/16.
 */
public class TeacherServiceImpl implements TeacherService {

    final int pageCols = 12;

    TeacherDao dao;

    public void setDao(TeacherDao dao) {
        this.dao = dao;
    }

    public TeacherEntity login(String uid, String password) {
        return dao.checkUser(uid, password);
    }

    public TeacherEntity register(TeacherEntity teacherEntity) {
        return dao.saveUser(teacherEntity);
    }

    public boolean delete(String userId) {
        TeacherEntity teacherEntity = dao.findById(userId);
        return teacherEntity != null && dao.deleteUser(teacherEntity);

    }

    public boolean update(TeacherEntity teacherEntity) {
        return dao.updateUser(teacherEntity);
    }

    public List<TeacherEntity> findAll() {
        List teachers = dao.findAll();
        List<TeacherEntity> list = new ArrayList<TeacherEntity>();
        for(Object teacher: teachers) {
            list.add((TeacherEntity)teacher);
        }
        return list;
    }

    public TeacherEntity findById(String uid) {
        return dao.findById(uid);
    }

    public List<TeacherEntity> getData(int page) {
        List teachers = dao.getData((page-1)*pageCols, pageCols);
        List<TeacherEntity> list = new ArrayList<TeacherEntity>();
        for (Object teacher: teachers) {
            list.add((TeacherEntity)teacher);
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
