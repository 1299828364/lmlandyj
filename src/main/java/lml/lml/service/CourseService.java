package lml.lml.service;

import lml.lml.domain.Course;
import lml.lml.domain.Result;

import java.util.Date;
import java.util.List;

/**
 * @author xxx
 */
public interface CourseService {

    /**
     * 查询所有的文章
     *
     * @return
     */
    Result findAll();

    /**
     *
     */
    Result addCourse(Course course);

    /**
     *
     */
    Result findByDate(Date start,Date end);


    /**
     *
     * @param course
     * @return
     */
    Result deleteCourse(Course course);

    /**
     *
     * @param courseNo
     * @return
     */
    Result deleteCourse(String courseNo);


    Result updateCourse(Course course);

}
