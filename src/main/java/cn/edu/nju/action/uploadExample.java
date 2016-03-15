package cn.edu.nju.action;

import cn.edu.nju.entity.CompleteSelectedCourseEntity;
import cn.edu.nju.entity.ExampleFileEntity;
import cn.edu.nju.entity.HomeworkEntity;
import cn.edu.nju.entity.StudentHomeworkEntity;
import cn.edu.nju.service.TeacherService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by weiyilin on 16/3/14.
 */
public class uploadExample extends ActionSupport {
    private File myFile;
    private String myFileContentType;
    private String myFileFileName;
    private String destPath;

    private TeacherService teacherService;
    private ExampleFileEntity exampleFileEntity;
    private HomeworkEntity homeworkEntity;
    private StudentHomeworkEntity studentHomeworkEntity;
    private List<CompleteSelectedCourseEntity> selCourses;

    private int csid;
    private int hid;
    private int efid;
    private String ddl;
    private String description;

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

    public TeacherService getTeacherService() {
        return teacherService;
    }

    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    public ExampleFileEntity getExampleFileEntity() {
        return exampleFileEntity;
    }

    public void setExampleFileEntity(ExampleFileEntity exampleFileEntity) {
        this.exampleFileEntity = exampleFileEntity;
    }

    public HomeworkEntity getHomeworkEntity() {
        return homeworkEntity;
    }

    public void setHomeworkEntity(HomeworkEntity homeworkEntity) {
        this.homeworkEntity = homeworkEntity;
    }

    public StudentHomeworkEntity getStudentHomeworkEntity() {
        return studentHomeworkEntity;
    }

    public void setStudentHomeworkEntity(StudentHomeworkEntity studentHomeworkEntity) {
        this.studentHomeworkEntity = studentHomeworkEntity;
    }

    public List<CompleteSelectedCourseEntity> getSelCourses() {
        return selCourses;
    }

    public void setSelCourses(List<CompleteSelectedCourseEntity> selCourses) {
        this.selCourses = selCourses;
    }

    public int getCsid() {
        return csid;
    }

    public void setCsid(int csid) {
        this.csid = csid;
    }

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
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

    public int getEfid() {
        return efid;
    }

    public void setEfid(int efid) {
        this.efid = efid;
    }

    @Override
    public String execute() throws Exception {
        homeworkEntity = new HomeworkEntity();
        homeworkEntity.setCsid(csid);
        homeworkEntity.setDeadline(ddl);
        homeworkEntity.setDescription(description);
        hid = teacherService.publishHomework(homeworkEntity).getHid();
        selCourses = teacherService.findSelCourse(csid);
        for (CompleteSelectedCourseEntity c : selCourses){
            studentHomeworkEntity = new StudentHomeworkEntity();
            studentHomeworkEntity.setHid(hid);
            studentHomeworkEntity.setUid(c.getUid());
            teacherService.publishStuHomework(studentHomeworkEntity);
        }

        destPath = "/Users/weiyilin/Desktop/file";
        try{
            File destFile  = new File(destPath, myFileFileName);
            FileUtils.copyFile(myFile, destFile);
        }catch(IOException e){
            e.printStackTrace();
            return ERROR;
        }
        exampleFileEntity = new ExampleFileEntity();
        exampleFileEntity.setEfname(myFileFileName);
        efid = teacherService.uploadExample(exampleFileEntity).getEfid();
        homeworkEntity = teacherService.findHomeworkById(hid);
        homeworkEntity.setEfid(efid);
        teacherService.publishHomework(homeworkEntity);
        return SUCCESS;
    }
}
