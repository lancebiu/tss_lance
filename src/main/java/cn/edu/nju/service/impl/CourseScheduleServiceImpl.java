package cn.edu.nju.service.impl;

import cn.edu.nju.dao.CourseScheduleDao;
import cn.edu.nju.entity.CompleteCourseScheduleEntity;
import cn.edu.nju.entity.CourseScheduleEntity;
import cn.edu.nju.service.CourseScheduleService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lance on 2/13/16.
 */
public class CourseScheduleServiceImpl implements CourseScheduleService {

    CourseScheduleDao dao;

    public void setDao(CourseScheduleDao dao) {
        this.dao = dao;
    }

    public CourseScheduleEntity add(CourseScheduleEntity courseScheduleEntity) {
        return dao.saveSchedule(courseScheduleEntity);
    }

    public boolean delete(int csid) {
        CourseScheduleEntity schedule = dao.findById(csid);
        return schedule != null && dao.deleteSchedule(schedule);
    }

    public boolean update(CourseScheduleEntity courseScheduleEntity) {
        return dao.update(courseScheduleEntity);
    }

    public List<CompleteCourseScheduleEntity> findAllSchedule(String term) {
        List schedules = dao.findAllSchedule(term);
        List<CompleteCourseScheduleEntity> list = new ArrayList<CompleteCourseScheduleEntity>();
        for (Object schedule: schedules) {
            list.add((CompleteCourseScheduleEntity) schedule);
        }
        return list;
    }

    public List<CourseScheduleEntity> findAllScheduleToBeAllocated(String term) {
        List schedules = dao.findAllScheduleToBeAllocated(term);
        List<CourseScheduleEntity> list = new ArrayList<CourseScheduleEntity>();
        for (Object schedule: schedules) {
            list.add((CourseScheduleEntity) schedule);
        }
        return list;
    }

    public CourseScheduleEntity findById(int csid) {
        return dao.findById(csid);
    }

    public CompleteCourseScheduleEntity findByCTT(String cid, String term, String teacher) {
        return dao.findByCTT(cid, term, teacher);
    }

}
