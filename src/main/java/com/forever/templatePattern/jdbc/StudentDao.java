package com.forever.templatePattern.jdbc;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDao extends JdbcTemplate{

    public StudentDao(DataSource dataSource) {
        super(dataSource);
    }

    public List<?> excuteAll(){
        String sql = "select * from student";
        RowMapper<Student> rowMapper = new StudentMapper();
        /*return super.excuteQuery(sql, new RowMapper<Student>() {
                 public Student mapRow(ResultSet rs, int rowNum) throws Exception {
                    Student stu = new Student();
                    stu.setName(rs.getString("name"));
                    stu.setSex(rs.getString("sex"));
                    stu.setAge(rs.getString("age"));
                    return stu;
                }
            },null);*/
        return super.excuteQuery(sql, rowMapper, null);
    }
}
