package lml.lml.repository;


import lml.lml.domain.Course;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
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
    Course findOneByNo(String courseNo);

    /**
     *
     * @return
     * @param courseNo
     */
    boolean deleteByCourseNo(@Param("courseNo") String courseNo);


    /**
     *
     * @return
     */
    boolean editCourse(Course course);

    List<Course> findByDate(@Param("start") Date start,@Param("end")Date end);


    /**
     *
     * @return
     */
    boolean dispatchCourse();

    List findCourseWithColumn();
}
