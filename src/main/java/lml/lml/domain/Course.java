package lml.lml.domain;

import java.util.Date;

public class Course {
    private Integer courseNo;
    private String courseTitle;
    private String content;
    private Date createDate;
    private Integer state;
    private Integer columnNo;
    private Integer count;

    public Integer getcourseNo() {
        return courseNo;
    }

    public void setcourseNo(Integer courseNo) {
        this.courseNo = courseNo;
    }

    public String getcourseTitle() {
        return courseTitle;
    }

    public void setcourseTitile(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getClumnNo() {
        return columnNo;
    }

    public void setClumnNo(Integer columnNo) {
        this.columnNo = columnNo;
    }
}
