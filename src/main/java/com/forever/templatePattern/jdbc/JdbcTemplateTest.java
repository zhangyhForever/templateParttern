package com.forever.templatePattern.jdbc;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class JdbcTemplateTest {
    public static void main(String[] args) {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/school");
        ds.setUsername("root");
        ds.setPassword("123456");

       /* try{
            Connection conn = ds.getConnection();
            System.out.println(conn);
            String sql = "select * from student";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("name"));
            }
            rs.close();
            pstm.close();
            conn.close();
        } catch (Exception e){
            e.printStackTrace();
        }
*/

        StudentDao dao = new StudentDao(ds);
        List<Student> student = (List<Student>)dao.excuteAll();
        for(Student s: student){
            System.out.println(s.getName());
        }
    }
}
