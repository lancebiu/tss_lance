package cn.edu.nju.action;

import cn.edu.nju.entity.*;
import cn.edu.nju.service.StudentService;
import cn.edu.nju.service.TeacherService;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by weiyilin on 16/3/13.
 */
public class TeacherAction extends BaseAction {
    private TeacherService teacherService;
    private StudentService studentService;

    private List<CompleteCourseScheduleEntity> courses;
    private List<CompleteSelectedCourseEntity> selCourses;
    private List<CompleteHomeworkEntity> stuHomeworks;
    private List<HomeworkEntity> homeworks;
    private List<AssistCourseEntity> ass;

    private List<Integer> stuNumsPerCourse;

    private StudentEntity studentEntity;
    private HomeworkEntity homeworkEntity;
    private AssistantEntity assistantEntity;
    private ExampleFileEntity exampleFileEntity;
    private StudentHomeworkEntity studentHomeworkEntity;

    private String uname;
    private String cid;
    private String uid;
    private String tid;
    private String term;
    private String ddl;
    private String description;
    private String cname;
    private int csid;
    private int stuNum;
    private int hwNUm;
    private int hid;
    private int efid;
    private int shid;

    private File myFile;
    private String myFileContentType;
    private String myFileFileName;
    private String destPath;

    public TeacherService getTeacherService() {
        return teacherService;
    }

    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    public List<CompleteCourseScheduleEntity> getCourses() {
        return courses;
    }

    public void setCourses(List<CompleteCourseScheduleEntity> courses) {
        this.courses = courses;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public int getCsid() {
        return csid;
    }

    public void setCsid(int csid) {
        this.csid = csid;
    }

    public HomeworkEntity getHomeworkEntity() {
        return homeworkEntity;
    }

    public void setHomeworkEntity(HomeworkEntity homeworkEntity) {
        this.homeworkEntity = homeworkEntity;
    }

    public String getDdl() {
        return ddl;
    }

    public void setDdl(String ddl) {
        this.ddl = ddl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CompleteHomeworkEntity> getStuHomeworks() {
        return stuHomeworks;
    }

    public void setStuHomeworks(List<CompleteHomeworkEntity> stuHomeworks) {
        this.stuHomeworks = stuHomeworks;
    }

    public List<HomeworkEntity> getHomeworks() {
        return homeworks;
    }

    public void setHomeworks(List<HomeworkEntity> homeworks) {
        this.homeworks = homeworks;
    }


    public List<CompleteSelectedCourseEntity> getSelCourses() {
        return selCourses;
    }

    public void setSelCourses(List<CompleteSelectedCourseEntity> selCourses) {
        this.selCourses = selCourses;
    }

    public List<Integer> getStuNumsPerCourse() {
        return stuNumsPerCourse;
    }

    public void setStuNumsPerCourse(List<Integer> stuNumsPerCourse) {
        this.stuNumsPerCourse = stuNumsPerCourse;
    }

    public AssistantEntity getAssistantEntity() {
        return assistantEntity;
    }

    public void setAssistantEntity(AssistantEntity assistantEntity) {
        this.assistantEntity = assistantEntity;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public String getDestPath() {
        return destPath;
    }

    public void setDestPath(String destPath) {
        this.destPath = destPath;
    }

    public ExampleFileEntity getExampleFileEntity() {
        return exampleFileEntity;
    }

    public void setExampleFileEntity(ExampleFileEntity exampleFileEntity) {
        this.exampleFileEntity = exampleFileEntity;
    }

    public StudentHomeworkEntity getStudentHomeworkEntity() {
        return studentHomeworkEntity;
    }

    public void setStudentHomeworkEntity(StudentHomeworkEntity studentHomeworkEntity) {
        this.studentHomeworkEntity = studentHomeworkEntity;
    }

    public int getStuNum() {
        return stuNum;
    }

    public void setStuNum(int stuNum) {
        this.stuNum = stuNum;
    }

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public int getEfid() {
        return efid;
    }

    public void setEfid(int efid) {
        this.efid = efid;
    }

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public int getShid() {
        return shid;
    }

    public void setShid(int shid) {
        this.shid = shid;
    }

    public int getHwNUm() {
        return hwNUm;
    }

    public void setHwNUm(int hwNUm) {
        this.hwNUm = hwNUm;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public List<AssistCourseEntity> getAss() {
        return ass;
    }

    public void setAss(List<AssistCourseEntity> ass) {
        this.ass = ass;
    }

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String findMyCourse(){
        term = "2016-1";
        stuNumsPerCourse = new ArrayList<Integer>();
        courses = teacherService.findCourse(tid, term);
        for(CompleteCourseScheduleEntity course : courses){
            stuNum = teacherService.findSelCourse(course.getCsid()).size();
            stuNumsPerCourse.add(stuNum);
        }
        return "findMyCourse";
    }

    public String findMyHomework(){
        homeworks = teacherService.findHomework(csid);
        hwNUm = homeworks.size() + 1;
        return "findMyHomework";
    }

    public String findMyStuHomework(){
        stuHomeworks = teacherService.findStuHomework(csid, hid);
        return "findMyStuHomework";
    }

    public String addHomework(){
        return "addHomework";
    }

    public String addAss() {
        ass = teacherService.findAss(csid);
        return "addAss";
    }

    public String arrangeAssistant(){
        assistantEntity = new AssistantEntity();
        assistantEntity.setUid(uid);
        assistantEntity.setCsid(csid);
        teacherService.arrangeAssistant(assistantEntity);
        studentEntity = studentService.findById(uid);
        uname = studentEntity.getUname();
        return "arrangeAssistant";
    }

    public String acceptHomework(){
        studentHomeworkEntity = studentService.findHomeworkById(shid);
        studentHomeworkEntity.setStatus(2);
        studentService.examHomework(studentHomeworkEntity);
        return "acceptHomework";
    }

    public String rejectHomework(){
        studentHomeworkEntity = studentService.findHomeworkById(shid);
        studentHomeworkEntity.setStatus(3);
        studentService.examHomework(studentHomeworkEntity);
        return "rejectHomework";
    }

}
