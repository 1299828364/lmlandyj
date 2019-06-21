package lml.lml.service;

import lml.lml.domain.Course;

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
    List<Course> findAll();
}
