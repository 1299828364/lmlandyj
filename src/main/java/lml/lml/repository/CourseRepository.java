package lml.lml.repository;


import lml.lml.domain.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository {

    /**
     *
     * @return
     */
    List<Course> findAll();


    /**
     *
     * @param courseNo
     * @return
     */
    Course getOneByNo(String courseNo);

    /**
     *
     * @return
     */
    boolean deleteOne();

    /**
     *
     * @return
     */
    boolean addCourse();


    /**
     *
     * @return
     */
    boolean dispatchCourse();
}
