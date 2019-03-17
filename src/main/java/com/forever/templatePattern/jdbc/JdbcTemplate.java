package com.forever.templatePattern.jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public abstract class JdbcTemplate {

    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public List<?> excuteQuery(String sql, RowMapper<?> rowMapper, Object[] params) {
        List<?> result = null;
        try {
            //获得连接
            Connection conn = this.getConnection();
            //创建语句集
            PreparedStatement pstm = this.createPrepareStatement(conn, sql);
            //结果集
            ResultSet rs = this.getResultSet(pstm, params);
            //处理结果集
            result = this.parseResultSet(rs, rowMapper);
            //关闭结果集、语句集、连接
            this.closeResultSet(rs);
            this.closePreparedStatement(pstm);
            this.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    protected void closeConnection(Connection conn) throws Exception {
        //子类可以重写该方法，比如使用连接池时不用关闭连接，而是释放连接
        conn.close();
    }

    protected void closePreparedStatement(PreparedStatement pstm) throws Exception {
        pstm.close();
    }

    protected void closeResultSet(ResultSet rs) throws Exception {
        rs.close();
    }

    protected List<?> parseResultSet(ResultSet rs, RowMapper<?> rowMapper) throws Exception {
        List<Object> result = new ArrayList<Object>();
        int rowNum = 1;
        while (rs.next()){
            Object o = rowMapper.mapRow(rs, rowNum++);
            result.add(o);
        }
        return result;
    }

    protected ResultSet getResultSet(PreparedStatement pstm, Object[] params) throws Exception {
        if(params != null){
            for(int i=0; i<params.length; i++){
                pstm.setObject(i, params[i]);
            }
        }
        return pstm.executeQuery();
    }

    protected  PreparedStatement createPrepareStatement(Connection conn, String sql) throws Exception {
        return conn.prepareStatement(sql);
    }

    protected Connection getConnection() throws Exception {
        return dataSource.getConnection();
    }
}
