package cn.edu.nju.service;

import cn.edu.nju.entity.*;

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
    //homework
    public List<CompleteCourseScheduleEntity> findCourse(String tid, String term);
    public List<CompleteSelectedCourseEntity> findSelCourse(int csid);
    public List<HomeworkEntity> findHomework(int csid);
    public HomeworkEntity findHomeworkById(int hid);
    public List<CompleteHomeworkEntity> findStuHomework(int csid, int hid);
    public HomeworkEntity publishHomework(HomeworkEntity homeworkEntity);
    public ExampleFileEntity uploadExample(ExampleFileEntity exampleFileEntity);
    public StudentHomeworkEntity publishStuHomework(StudentHomeworkEntity studentHomeworkEntity);
    //assistant
    public boolean arrangeAssistant(AssistantEntity assistantEntity);
    public List<AssistCourseEntity> findAss(int csid);
}
