package cn.edu.nju.dao;

import cn.edu.nju.entity.CompleteCourseScheduleEntity;
import cn.edu.nju.entity.CourseScheduleEntity;

import java.util.List;

/**
 * Created by lance on 2/13/16.
 */
public interface CourseScheduleDao {

    public CourseScheduleEntity saveSchedule(CourseScheduleEntity courseScheduleEntity);
    public boolean deleteSchedule(CourseScheduleEntity courseScheduleEntity);
    public boolean update(CourseScheduleEntity courseScheduleEntity);
    public List findAllSchedule(String term);
    public List findAllScheduleToBeAllocated(String term);
    public CourseScheduleEntity findById(int csid);
    public CompleteCourseScheduleEntity findByCTT(String cid, String term, String tid);
}