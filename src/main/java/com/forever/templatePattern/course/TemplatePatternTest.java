package com.forever.templatePattern.course;

public class TemplatePatternTest {
    public static void main(String[] args) {
        System.out.println("-------java开上上课--------");
        CourseTemplate java = new JavaCourse();
        ((JavaCourse) java).setHomeworkFlag(true);
        java.createCourse();

        System.out.println("-------大数据开始上课-----------");
        CourseTemplate bigData = new BigDataCourse(true);
        bigData.createCourse();
    }
}
