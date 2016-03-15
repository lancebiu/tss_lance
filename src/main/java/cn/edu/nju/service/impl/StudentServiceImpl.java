package cn.edu.nju.service.impl;

import cn.edu.nju.dao.StudentDao;
import cn.edu.nju.entity.*;
import cn.edu.nju.service.StudentService;
import sun.security.krb5.internal.crypto.Des;

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

    public CourseSelectionEntity selectCourse(CourseSelectionEntity courseSelectionEntity) {
        return dao.selectCourse(courseSelectionEntity);
    }

    public List<CompleteSelectedCourseEntity> findMyCourse(String uid, String term) {
        List courses = dao.findMyCourse(uid, term);
        List<CompleteSelectedCourseEntity> list = new ArrayList<CompleteSelectedCourseEntity>();
        for (Object course: courses){
            list.add((CompleteSelectedCourseEntity) course);
        }
        return list;
    }

    public boolean deleteAllCourse(String uid) {
        List courses = dao.findMySelectedCourse(uid);
        for (Object course: courses){
            dao.deleteCourse((CourseSelectionEntity) course);
        }
        return true;
    }

    public StudentHomeworkEntity findHomeworkById(int shid) {
        return dao.findHomeworkById(shid);
    }

    public StudentHomeworkEntity findHomeworkById(int hid, String uid) {
        return dao.findHomeworkById(hid, uid);
    }

    public List<DesHomeworkEntity> findHomework(String uid, int csid) {
        List homeworks = dao.findHomework(uid, csid);
        List<DesHomeworkEntity> list = new ArrayList<DesHomeworkEntity>();
        for(Object homework : homeworks){
            list.add((DesHomeworkEntity) homework);
        }
        return list;
    }

    public HomeworkFileEntity uploadFile(HomeworkFileEntity homeworkFileEntity) {
        return dao.uploadHomework(homeworkFileEntity);
    }

    public StudentHomeworkEntity uploadStuHomework(StudentHomeworkEntity studentHomeworkEntity) {
        return dao.uploadStuHomework(studentHomeworkEntity);
    }

    public List<AssistCourseEntity> findAsCourse(String uid) {
        List courses = dao.findAsCourse(uid);
        List<AssistCourseEntity> list = new ArrayList<AssistCourseEntity>();
        for(Object course : courses){
            list.add((AssistCourseEntity)course);
        }
        return list;
    }

    public List<AssistantEntity> findAllAs() {
        List ass = dao.findAllAs();
        List<AssistantEntity> list = new ArrayList<AssistantEntity>();
        for(Object as : ass){
            list.add((AssistantEntity) as);
        }
        return list;
    }

    public List<CompleteHomeworkEntity> findStuHomework(int csid) {
        List homeworks  = dao.findStuHomework(csid);
        List<CompleteHomeworkEntity> list = new ArrayList<CompleteHomeworkEntity>();
        for(Object homework : homeworks){
            list.add((CompleteHomeworkEntity)homework);
        }
        return list;
    }

    public boolean examHomework(StudentHomeworkEntity studentHomeworkEntity) {
        return dao.examHomework(studentHomeworkEntity);
    }
}