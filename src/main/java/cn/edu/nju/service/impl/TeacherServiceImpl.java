package cn.edu.nju.service.impl;

import cn.edu.nju.dao.TeacherDao;
import cn.edu.nju.entity.*;
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

    public List<CompleteCourseScheduleEntity> findCourse(String tid, String term) {
        List courses = dao.findCourse(tid, term);
        List<CompleteCourseScheduleEntity> list = new ArrayList<CompleteCourseScheduleEntity>();
        for(Object course : courses){
            list.add((CompleteCourseScheduleEntity)course);
        }
        return list;
    }

    public List<CompleteSelectedCourseEntity> findSelCourse(int csid) {
        List courses = dao.findSelCourse(csid);
        List<CompleteSelectedCourseEntity> list = new ArrayList<CompleteSelectedCourseEntity>();
        for(Object course : courses){
            list.add((CompleteSelectedCourseEntity) course);
        }
        return list;
    }

    public List<HomeworkEntity> findHomework(int csid) {
        List homeworks = dao.findHomework(csid);
        List<HomeworkEntity> list = new ArrayList<HomeworkEntity>();
        for(Object homework : homeworks){
            list.add((HomeworkEntity)homework);
        }
        return list;
    }

    public HomeworkEntity findHomeworkById(int hid) {
        return dao.findHomeworkById(hid);
    }

    public List<CompleteHomeworkEntity> findStuHomework(int csid, int hid) {
        List homeworks = dao.findStuHomework(csid, hid);
        List<CompleteHomeworkEntity> list = new ArrayList<CompleteHomeworkEntity>();
        for(Object homework : homeworks){
            list.add((CompleteHomeworkEntity) homework);
        }
        return list;
    }

    public HomeworkEntity publishHomework(HomeworkEntity homeworkEntity) {
        return dao.publishHomework(homeworkEntity);
    }

    public ExampleFileEntity uploadExample(ExampleFileEntity exampleFileEntity) {
        return dao.uploadExample(exampleFileEntity);
    }

    public StudentHomeworkEntity publishStuHomework(StudentHomeworkEntity studentHomeworkEntity) {
        return dao.pulishStuHomework(studentHomeworkEntity);
    }

    public boolean arrangeAssistant(AssistantEntity assistantEntity) {
        return dao.arrangeAssistant(assistantEntity);
    }

    public List<AssistCourseEntity> findAss(int csid) {
        List ass = dao.findAss(csid);
        List<AssistCourseEntity> list = new ArrayList<AssistCourseEntity>();
        for(Object as : ass){
            list.add((AssistCourseEntity) as);
        }
        return list;
    }

}
