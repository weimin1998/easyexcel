package com.weimin.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.weimin.pojo.Student;

public class StudentListener extends AnalysisEventListener<Student> {

    public void invoke(Student student, AnalysisContext analysisContext) {
        System.out.println(student.toString());
        System.out.println("save db: " + student);
    }

    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
