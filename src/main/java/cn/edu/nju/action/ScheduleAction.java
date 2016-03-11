package cn.edu.nju.action;

import cn.edu.nju.entity.CompleteCourseScheduleEntity;
import cn.edu.nju.entity.CourseEntity;
import cn.edu.nju.entity.CourseScheduleEntity;
import cn.edu.nju.entity.TeacherEntity;
import cn.edu.nju.service.CourseScheduleService;
import cn.edu.nju.service.CourseService;
import cn.edu.nju.service.TeacherService;
import org.apache.struts2.json.annotations.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lance on 2/13/16.
 */

public class ScheduleAction extends BaseAction {

    private CourseScheduleService scheduleService;
    private CourseService courseService;
    private TeacherService teacherService;

    private List<CourseEntity> courses;
    private List<CourseScheduleEntity> schedules;
    private List<TeacherEntity> teachers;
    private List<CompleteCourseScheduleEntity> completeSchedules;
    private CourseScheduleEntity schedule;
    private String[] tids;

    private int csid;
    private String cid;
    private String tid;
    private String term;


    @JSON(serialize = false)
    public CourseScheduleService getScheduleService() {
        return scheduleService;
    }

    public void setScheduleService(CourseScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @JSON(serialize = false)
    public CourseService getCourseService() {
        return courseService;
    }

    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @JSON(serialize = false)
    public TeacherService getTeacherService() {
        return teacherService;
    }

    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
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

    public List<TeacherEntity> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<TeacherEntity> teachers) {
        this.teachers = teachers;
    }

    public List<CompleteCourseScheduleEntity> getCompleteSchedules() {
        return completeSchedules;
    }

    public void setCompleteSchedules(List<CompleteCourseScheduleEntity> completeSchedules) {
        this.completeSchedules = completeSchedules;
    }

    public CourseScheduleEntity getSchedule() {
        return schedule;
    }

    public void setSchedule(CourseScheduleEntity schedule) {
        this.schedule = schedule;
    }

    public String[] getTids() {
        return tids;
    }

    public void setTids(String[] tids) {
        this.tids = tids;
    }

    public int getCsid() {
        return csid;
    }

    public void setCsid(int csid) {
        this.csid = csid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
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

    public String list() {
        schedules = scheduleService.findAllScheduleToBeAllocated(term);
        courses = new ArrayList<CourseEntity>();
        for (CourseScheduleEntity scheduleEntity : schedules) {
            courses.add(courseService.findById(scheduleEntity.getCid()));
        }
        return "list";
    }

    public String schedules() {
        completeSchedules = scheduleService.findAllSchedule(term);
        return "schedules";
    }

    public String add() {
        schedule = new CourseScheduleEntity();
        schedule.setCsid(0);
        schedule.setCid(cid);
        schedule.setTerm(term);
        schedule = scheduleService.add(schedule);
        if (schedule != null) {
            schedules = scheduleService.findAllScheduleToBeAllocated(term);
            schedule = schedules.get(schedules.size() - 1);
            csid = schedule.getCsid();
            return "add";
        } else {
            return ERROR;
        }
    }

    public String delete() {
        schedule = scheduleService.findById(csid);
        completeSchedules = scheduleService.findAllSchedule(schedule.getTerm());
        for (CompleteCourseScheduleEntity completeSchedule : completeSchedules) {
            if (completeSchedule.getCid().equals(schedule.getCid())) {
                return ERROR;
            }
        }
        scheduleService.delete(csid);
        return "delete";
    }

    public String update() {
        if (scheduleService.update(schedule)) {
            return "update";
        } else {
            return ERROR;
        }
    }

    public String teachers() {
        List<TeacherEntity> list = teacherService.findAll();
        teachers = new ArrayList<TeacherEntity>();
        schedule = scheduleService.findById(csid);

        completeSchedules = scheduleService.findAllSchedule(schedule.getTerm());
        ArrayList<String> tids = new ArrayList<String>();
        for (CompleteCourseScheduleEntity completeSchedule : completeSchedules) {
            if (completeSchedule.getCid().equals(schedule.getCid())) {
                tids.add(completeSchedule.getTid());
            }
        }

        boolean flag;
        for (TeacherEntity teacher : list) {
            flag = false;
            for (String tid : tids) {
                if (teacher.getTid().equals(tid)) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                teachers.add(teacher);
            }
        }

        return "teachers";
    }

    public String addTeacher() {
        teachers = new ArrayList<TeacherEntity>();
        schedule = scheduleService.findById(csid);
        for (String tid : tids) {
            teachers.add(teacherService.findById(tid));
            schedule.setTid(tid);
            schedule.setCsid(0);
            scheduleService.add(schedule);
        }
        cid = schedule.getCid();
        completeSchedules = scheduleService.findAllSchedule(schedule.getTerm());
        return "addTeacher";
    }

    public String deleteTeacher() {
        scheduleService.delete(scheduleService.findByCTT(cid, term, tid).getCsid());
        completeSchedules = scheduleService.findAllSchedule(term);
        return "deleteTeacher";
    }

}