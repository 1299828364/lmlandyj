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


    List<Course> findByPage(@Param("page")int page);

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

    List<Course> findByDate(@Param("page")int page,@Param("start") Date start,@Param("end")Date end);


    List<Course> findByDateWithTitle(@Param("page")int page,@Param("start") Date start,@Param("end")Date end,@Param("title")String title);


    /**
     *
     * @return
     */
    boolean dispatchCourse();

    List findCourseWithColumn();

    List findCourseWithColumnByPage(@Param("page")int page);


    boolean setState(Course course);
}
