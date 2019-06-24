package lml.lml.service.impl;


import lml.lml.domain.Course;
import lml.lml.domain.Result;
import lml.lml.utils.*;
import lml.lml.repository.CourseRepository;
import lml.lml.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author xxx
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;


    @Override
    public Result findAll() {
        return ResultUtil.success(courseRepository.findAll());
    }

    @Override
    public Result addCourse(Course course) {
        course.setCourseNo(EntityIDFactory.createID());
        course.setCreateDate(EntityCreateDateFactroy.getCreateDate());
        return ResultUtil.success(courseRepository.editCourse(course));
    }

    @Override
    public Result findByDate(Date start, Date end) {
        return ResultUtil.success(courseRepository.findByDate(start,end));
    }

    @Override
    public Result deleteCourse(Course course) {
        return ResultUtil.success(courseRepository.deleteByCourseNo(course.getCourseNo()));
    }

    @Override
    public Result deleteCourse(String courseNo) {
        return ResultUtil.success(courseRepository.deleteByCourseNo(courseNo));
    }

    @Override
    public Result updateCourse(Course course) {
        return ResultUtil.success(courseRepository.editCourse(course));
    }

    @Override
    public Result updateState(Course course) {
        course.setState(course.getState()==1?2:1);
        return ResultUtil.success(courseRepository.editCourse(course));
    }

    @Override
    public Result findCourseWithColumn() {
        return ResultUtil.success(courseRepository.findCourseWithColumn());
    }

    @Override
    public Result findOneByNo(String no) {
        return ResultUtil.success(courseRepository.findOneByNo(no));
    }


}
