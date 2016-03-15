package cn.edu.nju.action;

import cn.edu.nju.entity.*;
import cn.edu.nju.service.CourseScheduleService;
import cn.edu.nju.service.StudentService;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.json.annotations.JSON;
import sun.security.krb5.internal.crypto.Des;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by weiyilin on 16/3/12.
 */
public class StudentAction extends BaseAction {
    private StudentService studentService;
    private CourseScheduleService courseScheduleService;

    private CourseSelectionEntity courseSelectionEntity;
    private HomeworkFileEntity homeworkFileEntity;
    private StudentHomeworkEntity studentHomeworkEntity;

    private List<CompleteCourseScheduleEntity> courses;
    private List<CompleteSelectedCourseEntity> completeCourses;
    private List<DesHomeworkEntity> homeworks;

    private String[] csids;
    private String term;
    private String uid;
    private String cname;
    private int csid;
    private int fid;
    private int hid;

    private File myFile;
    private String myFileContentType;
    private String myFileFileName;
    private String destPath;

    @JSON(serialize=false)
    public CourseScheduleService getCourseScheduleService() {
        return courseScheduleService;
    }

    public void setCourseScheduleService(CourseScheduleService courseScheduleService) {
        this.courseScheduleService = courseScheduleService;
    }

    @JSON(serialize=false)
    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public CourseSelectionEntity getCourseSelectionEntity() {
        return courseSelectionEntity;
    }

    public void setCourseSelectionEntity(CourseSelectionEntity courseSelectionEntity) {
        this.courseSelectionEntity = courseSelectionEntity;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public List<CompleteCourseScheduleEntity> getCourses() {
        return courses;
    }

    public void setCourses(List<CompleteCourseScheduleEntity> courses) {
        this.courses = courses;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String[] getCsids() {
        return csids;
    }

    public void setCsids(String[] csids) {
        this.csids = csids;
    }

    public List<CompleteSelectedCourseEntity> getCompleteCourses() {
        return completeCourses;
    }

    public void setCompleteCourses(List<CompleteSelectedCourseEntity> completeCourses) {
        this.completeCourses = completeCourses;
    }

    public List<DesHomeworkEntity> getHomeworks() {
        return homeworks;
    }

    public void setHomeworks(List<DesHomeworkEntity> homeworks) {
        this.homeworks = homeworks;
    }

    public int getCsid() {
        return csid;
    }

    public void setCsid(int csid) {
        this.csid = csid;
    }

    public File getMyFile() {
        return myFile;
    }

    public void setMyFile(File myFile) {
        this.myFile = myFile;
    }

    public String getMyFileContentType() {
        return myFileContentType;
    }

    public void setMyFileContentType(String myFileContentType) {
        this.myFileContentType = myFileContentType;
    }

    public String getMyFileFileName() {
        return myFileFileName;
    }

    public void setMyFileFileName(String myFileFileName) {
        this.myFileFileName = myFileFileName;
    }

    public HomeworkFileEntity getHomeworkFileEntity() {
        return homeworkFileEntity;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getDestPath() {
        return destPath;
    }

    public void setDestPath(String destPath) {
        this.destPath = destPath;
    }

    public void setHomeworkFileEntity(HomeworkFileEntity homeworkFileEntity) {
        this.homeworkFileEntity = homeworkFileEntity;
    }

    public StudentHomeworkEntity getStudentHomeworkEntity() {
        return studentHomeworkEntity;
    }

    public void setStudentHomeworkEntity(StudentHomeworkEntity studentHomeworkEntity) {
        this.studentHomeworkEntity = studentHomeworkEntity;
    }

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String allCourse(){
        term = "2016-1";
        courses = courseScheduleService.findAllSchedule(term);
        return "allCourse";
    }

    public String myCourse(){
        completeCourses = studentService.findMyCourse(uid, term);
        return "myCourse";
    }

    public String selectCourse(){
        studentService.deleteAllCourse(uid);
        for (String csid : csids){
            courseSelectionEntity = new CourseSelectionEntity();
            courseSelectionEntity.setCsid(Integer.parseInt(csid));
            courseSelectionEntity.setUid(uid);
            studentService.selectCourse(courseSelectionEntity);
        }
        return "selectCourse";
    }

    public String findHomework(){
        homeworks = studentService.findHomework(uid, csid);
        return "findHomework";
    }

}
