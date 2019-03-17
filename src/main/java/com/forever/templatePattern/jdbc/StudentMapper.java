package com.forever.templatePattern.jdbc;

import java.sql.ResultSet;

public class StudentMapper implements RowMapper<Student> {

    public Student mapRow(ResultSet rs, int rowNum) throws Exception {
        Student s = new Student();
        if(rs!=null){
            s.setName(rs.getString("name"));
            s.setSex(rs.getString("sex"));
            s.setAge(rs.getString("age"));
        }
        return s;
    }
}
