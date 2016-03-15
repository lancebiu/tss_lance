package cn.edu.nju.dao;

import cn.edu.nju.entity.*;

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
    //homework
    public List<CompleteCourseScheduleEntity> findCourse(String tid, String term);
    public List<CompleteSelectedCourseEntity> findSelCourse(int csid);
    public List<HomeworkEntity> findHomework(int csid);
    public HomeworkEntity findHomeworkById(int hid);
    public List<CompleteHomeworkEntity> findStuHomework(int csid, int hid);
    public HomeworkEntity publishHomework(HomeworkEntity homeworkEntity);
    public ExampleFileEntity uploadExample(ExampleFileEntity exampleFileEntity);
    public StudentHomeworkEntity pulishStuHomework(StudentHomeworkEntity studentHomeworkEntity);
    //assistant
    public boolean arrangeAssistant(AssistantEntity assistantEntity);
    public List<AssistCourseEntity> findAss(int csid);
}
