package cn.edu.nju.service;

import cn.edu.nju.entity.CompleteCourseScheduleEntity;
import cn.edu.nju.entity.CourseScheduleEntity;

import java.util.List;

/**
 * Created by lance on 2/13/16.
 */
public interface CourseScheduleService {

    public CourseScheduleEntity add(CourseScheduleEntity courseScheduleEntity);
    public boolean delete(int csid);
    public boolean update(CourseScheduleEntity courseScheduleEntity);
    public List<CompleteCourseScheduleEntity> findAllSchedule(String term);
    public List<CourseScheduleEntity> findAllScheduleToBeAllocated(String term);
    public CourseScheduleEntity findById(int csid);
    public CompleteCourseScheduleEntity findByCTT(String cid, String term, String teacher);
}