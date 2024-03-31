package com.weimin.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.weimin.converter.GenderConverter;
import lombok.Data;

import java.util.Date;

@Data
@ContentRowHeight(20)//内容的行高
@HeadRowHeight(20)// 表头的行高
public class Student {

    //@ExcelProperty(value = {"学生信息表", "学生姓名"})//表头
    @ExcelProperty(value =  "学生姓名")//表头
    @ColumnWidth(value = 20)//列宽，也可以写在类上
    private String name;

    //@ExcelProperty(value = {"学生信息表", "学生出生日期"})
    @ExcelProperty(value =  "学生出生日期")
    @ColumnWidth(value = 20)

    // 写入表格时，默认2024-03-31 16:14:09 这个格式
    @DateTimeFormat("yyyy-MM-dd")
    private Date birthday;

    // converter是个好东西，可以把1变成男，这种效果
    //@ExcelProperty(value = {"学生信息表", "学生性别"})
    @ExcelProperty(value =  "学生性别", converter = GenderConverter.class)
    @ColumnWidth(value = 20)
    private Integer gender;

    // index， 第几列

    //@ExcelProperty(value = "id", index = 0)
    @ExcelIgnore
    private String id;
}
