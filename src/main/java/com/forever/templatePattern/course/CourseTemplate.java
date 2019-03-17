package com.forever.templatePattern.course;

public abstract class CourseTemplate {

    protected final void createCourse(){
        //备课
        this.prepareCourse();
        //讲课
        this.speak();
        //写笔记
        this.writeNote();
        //录像
        this.record();
        //上传资料
        this.upload();
        //布置作业
        if(this.hasHomework()){
            //检查作业
            this.checkHomework();
        }

    }

    protected abstract void checkHomework();

    protected boolean hasHomework(){
        return false;
    }

    protected final void upload(){
        System.out.println("上传学习资料");
    }

    protected final void record(){
        System.out.println("录制课堂");
    }

    protected final void writeNote(){
        System.out.println("记录课堂笔记");
    }

    protected final void speak(){
        System.out.println("正在讲课");
    }

    protected final void prepareCourse(){
        System.out.println("课前备课");
    }
}
