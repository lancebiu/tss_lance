package cn.edu.nju.service;


import cn.edu.nju.entity.*;

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
    //student
    public CourseSelectionEntity selectCourse(CourseSelectionEntity courseSelectionEntity);
    public List<CompleteSelectedCourseEntity> findMyCourse(String uid, String term);
    public boolean deleteAllCourse(String uid);
    //homework
    public StudentHomeworkEntity findHomeworkById(int shid);
    public StudentHomeworkEntity findHomeworkById(int hid, String uid);
    public List<DesHomeworkEntity> findHomework(String uid, int csid);
    public HomeworkFileEntity uploadFile(HomeworkFileEntity homeworkFileEntity);
    public StudentHomeworkEntity uploadStuHomework(StudentHomeworkEntity studentHomeworkEntity);
    //assistant
    public List<AssistCourseEntity> findAsCourse(String uid);
    public List<AssistantEntity> findAllAs();
    public List<CompleteHomeworkEntity> findStuHomework(int csid);
    public boolean examHomework(StudentHomeworkEntity studentHomeworkEntity);
}
