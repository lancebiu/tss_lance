package cn.edu.nju.dao;

import cn.edu.nju.entity.*;

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
    //student
    public CourseSelectionEntity selectCourse(CourseSelectionEntity courseSelectionEntity);
    public List<CompleteSelectedCourseEntity> findMyCourse(String uid, String term);
    public boolean deleteCourse(CourseSelectionEntity courseSelectionEntity);
    public List<CourseSelectionEntity> findMySelectedCourse(String uid);
    //homework
    public StudentHomeworkEntity findHomeworkById(int shid);
    public StudentHomeworkEntity findHomeworkById(int hid, String uid);
    public List<DesHomeworkEntity> findHomework(String uid, int csid);
    public HomeworkFileEntity uploadHomework(HomeworkFileEntity homeworkFileEntity);
    public StudentHomeworkEntity uploadStuHomework(StudentHomeworkEntity studentHomeworkEntity);
    //assistant
    public List<AssistantEntity> findAllAs();
    public List<AssistCourseEntity> findAsCourse(String uid);
    public List<CompleteHomeworkEntity> findStuHomework(int csid);
    public boolean examHomework(StudentHomeworkEntity studentHomeworkEntity);
}
