package org.zhu.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.zhu.dao.InformationsDao;
import org.zhu.domain.Informations;
import org.zhu.util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author junhi
 * @Date 2019/5/27 14:59
 */
public class InformationsDaoImpl implements InformationsDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 获取所有的数据
     * @return
     */
    @Override
    public List<Informations> getAll() {

        List<Informations> list = new ArrayList<>();

        try {
            String sql = "select * from informations order by reportTime desc";
            PreparedStatement psmt = JDBCUtils.getConnection().prepareStatement(sql);

            ResultSet resultSet = psmt.executeQuery();

            while (resultSet.next()){
                Informations informations = new Informations();
                informations.setId(resultSet.getInt("id"));
                informations.setTitle(resultSet.getString("title"));
                informations.setContent( resultSet.getString("content"));
                informations.setReplyCount(resultSet.getInt("replyCount"));
                informations.setReportTime(resultSet.getString("reportTime"));
                list.add(informations);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 根据id，查询指定的一条数据
     * @param id
     * @return
     */
    @Override
    public Informations getOne(int id) {
        Informations informations = null;
        try {
            //1.定义sql
            String sql = "select * from informations where id = ?";
            //2.执行sql
            informations = template.queryForObject(sql, new BeanPropertyRowMapper<Informations>(Informations.class), id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return informations;
    }

    @Override
    public int updateReplyCount(int id) {
        String sql = "update informations set replyCount = (replyCount + 1) where id = ?";
        int rows = template.update(sql,id);
        return rows;
    }

    @Override
    public int addOne(Informations informations) throws SQLException {
        String sql = "insert into informations (title, content, replyCount, reportTime) values (?,?,?,?)";
        PreparedStatement psmt = JDBCUtils.getConnection().prepareStatement(sql);
        psmt.setString(1, informations.getTitle());
        psmt.setString(2, informations.getContent());
        psmt.setInt(3, 0);
        psmt.setString(4, String.valueOf(new Timestamp(new java.util.Date().getTime())));
        int rows = psmt.executeUpdate();
        return rows;
    }

    public static void main(String[] args) throws SQLException {

    }


}
