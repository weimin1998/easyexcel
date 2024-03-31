package com.weimin;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.weimin.listener.StudentListener;
import com.weimin.pojo.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test01 {

    // 从报表中读出数据
    @Test
    public void test1(){
        ExcelReaderBuilder excelReaderBuilder = EasyExcel.read("src/main/resources/杭州黑马在线202003班学员信息表.xlsx", Student.class, new StudentListener());

        ExcelReaderSheetBuilder sheet = excelReaderBuilder.sheet();

        sheet.doRead();

    }

    private static List<Student> initData() {
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Student data = new Student();
            data.setName("杭州黑马学号0" + i);
            data.setBirthday(new Date());
            data.setGender(1);
            students.add(data);
        }
        return students;
    }

    // 将数据导入报表
    @Test
    public void write(){
        ExcelWriterBuilder builder = EasyExcel.write("src/main/resources/write.xlsx", Student.class);

        ExcelWriterSheetBuilder sheet = builder.sheet();

        sheet.doWrite(initData());

    }
}
