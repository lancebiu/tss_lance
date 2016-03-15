package cn.edu.nju.action;

import cn.edu.nju.entity.HomeworkFileEntity;
import cn.edu.nju.entity.StudentHomeworkEntity;
import cn.edu.nju.service.StudentService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by weiyilin on 16/3/14.
 */
public class uploadHomework extends ActionSupport {
    private File myFile;
    private String myFileContentType;
    private String myFileFileName;
    private String destPath;

    private HomeworkFileEntity homeworkFileEntity;
    private StudentHomeworkEntity studentHomeworkEntity;

    private StudentService studentService;

    private int fid;
    private int hid;
    private String uid;

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

    public HomeworkFileEntity getHomeworkFileEntity() {
        return homeworkFileEntity;
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

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }


    @Override
    public String execute() throws Exception {
        destPath = "/Users/weiyilin/Desktop/file";
        try{
            File destFile  = new File(destPath, myFileFileName);
            FileUtils.copyFile(myFile, destFile);
        }catch(IOException e){
            e.printStackTrace();
            return ERROR;
        }

        uid = "131250114";
        homeworkFileEntity = new HomeworkFileEntity();
        homeworkFileEntity.setFname(myFileFileName);
        fid = studentService.uploadFile(homeworkFileEntity).getFid();
        studentHomeworkEntity = studentService.findHomeworkById(hid, uid);
        studentHomeworkEntity.setFid(fid);
        studentHomeworkEntity.setStatus(0);
        studentService.uploadStuHomework(studentHomeworkEntity);
        return SUCCESS;
    }
}
