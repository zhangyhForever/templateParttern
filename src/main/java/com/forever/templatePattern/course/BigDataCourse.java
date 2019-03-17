package com.forever.templatePattern.course;

public class BigDataCourse extends CourseTemplate {
    private boolean homeworkFlag;

    public BigDataCourse(boolean homeworkFlag){
        this.homeworkFlag = homeworkFlag;
    }

    @Override
    protected void checkHomework() {

    }
}
