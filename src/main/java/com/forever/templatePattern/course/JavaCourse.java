package com.forever.templatePattern.course;

public class JavaCourse extends CourseTemplate {
    private boolean homeworkFlag = false;

    public boolean isHomeworkFlag() {
        return homeworkFlag;
    }

    public void setHomeworkFlag(boolean homeworkFlag) {
        this.homeworkFlag = homeworkFlag;
    }

    @Override
    protected void checkHomework() {
        System.out.println("检查java作业");
    }

    @Override
    protected boolean hasHomework() {
        return this.homeworkFlag;
    }
}
