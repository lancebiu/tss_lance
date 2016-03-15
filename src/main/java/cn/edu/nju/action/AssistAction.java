package cn.edu.nju.action;

import cn.edu.nju.entity.*;
import cn.edu.nju.service.StudentService;
import cn.edu.nju.service.TeacherService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weiyilin on 16/3/13.
 */
public class AssistAction extends BaseAction {
    private StudentService studentService;
    private TeacherService teacherService;

    private List<AssistCourseEntity> courses;
    private List<CompleteHomeworkEntity> homeworks;
    private List<HomeworkEntity> homeworkEntities;

    private StudentHomeworkEntity homework;

    private List<Integer> stuNumsPerCourse;

    private String uid;
    private int csid;
    private int shid;
    private int hid;
    private int stuNum;
    private String score;
    private String cname;

    public TeacherService getTeacherService() {
        return teacherService;
    }

    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public List<AssistCourseEntity> getCourses() {
        return courses;
    }

    public void setCourses(List<AssistCourseEntity> courses) {
        this.courses = courses;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public List<CompleteHomeworkEntity> getHomeworks() {
        return homeworks;
    }

    public void setHomeworks(List<CompleteHomeworkEntity> homeworks) {
        this.homeworks = homeworks;
    }

    public int getCsid() {
        return csid;
    }

    public void setCsid(int csid) {
        this.csid = csid;
    }

    public StudentHomeworkEntity getHomework() {
        return homework;
    }

    public void setHomework(StudentHomeworkEntity homework) {
        this.homework = homework;
    }

    public int getShid() {
        return shid;
    }

    public void setShid(int shid) {
        this.shid = shid;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public List<HomeworkEntity> getHomeworkEntities() {
        return homeworkEntities;
    }

    public void setHomeworkEntities(List<HomeworkEntity> homeworkEntities) {
        this.homeworkEntities = homeworkEntities;
    }

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public List<Integer> getStuNumsPerCourse() {
        return stuNumsPerCourse;
    }

    public void setStuNumsPerCourse(List<Integer> stuNumsPerCourse) {
        this.stuNumsPerCourse = stuNumsPerCourse;
    }

    public int getStuNum() {
        return stuNum;
    }

    public void setStuNum(int stuNum) {
        this.stuNum = stuNum;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getAsCourse(){
        courses = studentService.findAsCourse(uid);
        stuNumsPerCourse = new ArrayList<Integer>();
        for(AssistCourseEntity course : courses){
            stuNum = teacherService.findSelCourse(course.getCsid()).size();
            stuNumsPerCourse.add(stuNum);
        }
        return "getAsCourse";
    }

    public String findMyHomework(){
        homeworkEntities = teacherService.findHomework(csid);
        return "findMyHomework";
    }

    public String findMyStuHomework(){
        homeworks = teacherService.findStuHomework(csid, hid);
        return "findMyStuHomework";
    }

    public String examHomework(){
        homework = studentService.findHomeworkById(shid);
        System.out.println("shid:"+shid);
        System.out.println("score:"+score);
        homework.setScore(score);
        homework.setStatus(1);
        studentService.examHomework(homework);
        return "examHomework";
    }
}
