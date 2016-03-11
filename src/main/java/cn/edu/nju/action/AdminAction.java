package cn.edu.nju.action;

import cn.edu.nju.entity.*;
import cn.edu.nju.service.CourseScheduleService;
import cn.edu.nju.service.CourseService;
import cn.edu.nju.service.StudentService;
import cn.edu.nju.service.TeacherService;
import org.apache.struts2.json.annotations.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lance on 2/12/16.
 */
public class AdminAction extends BaseAction {

    private StudentService studentService;
    private TeacherService teacherService;
    private CourseService courseService;
    private CourseScheduleService scheduleService;

    private List<StudentEntity> students;
    private List<TeacherEntity> teachers;
    private List<CourseEntity> courses;
    private List<CourseScheduleEntity> schedules;
    private List<CompleteCourseScheduleEntity> completeSchedules;

    private String term;

    private int page;
    private boolean pageCommit = false;
    private int totalPage;

    @JSON(serialize=false)
    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @JSON(serialize=false)
    public TeacherService getTeacherService() {
        return teacherService;
    }

    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @JSON(serialize=false)
    public CourseService getCourseService() {
        return courseService;
    }

    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @JSON(serialize=false)
    public CourseScheduleService getScheduleService() {
        return scheduleService;
    }

    public void setScheduleService(CourseScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    public List<StudentEntity> getStudents() {
        return students;
    }

    public void setStudents(List<StudentEntity> students) {
        this.students = students;
    }

    public List<TeacherEntity> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<TeacherEntity> teachers) {
        this.teachers = teachers;
    }

    public List<CourseEntity> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseEntity> courses) {
        this.courses = courses;
    }

    public List<CourseScheduleEntity> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<CourseScheduleEntity> schedules) {
        this.schedules = schedules;
    }

    public List<CompleteCourseScheduleEntity> getCompleteSchedules() {
        return completeSchedules;
    }

    public void setCompleteSchedules(List<CompleteCourseScheduleEntity> completeSchedules) {
        this.completeSchedules = completeSchedules;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
        pageCommit = true;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public String students() {
        if (!pageCommit)
            page = 1;
        students = studentService.getData(page);
        pageCommit = false;
        totalPage = studentService.getTotalPage();
        return "students";
    }

    public String teachers() {
        if (!pageCommit)
            page = 1;
        teachers = teacherService.getData(page);
        pageCommit = false;
        totalPage = teacherService.getTotalPage();
        return "teachers";
    }

    public String courses() {
        courses = courseService.findAll();
        return "courses";
    }

    public String schedules() {
        term = "2016-1";
        schedules = scheduleService.findAllScheduleToBeAllocated(term);
        completeSchedules = scheduleService.findAllSchedule(term);
        courses = new ArrayList<CourseEntity>();
        for (CourseScheduleEntity scheduleEntity: schedules) {
            courses.add(courseService.findById(scheduleEntity.getCid()));
        }
        return "schedules";
    }

}