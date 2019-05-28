package org.zhu.dao;

import org.zhu.domain.Informations;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author junhi
 * @Date 2019/5/27 14:57
 */
public interface InformationsDao {

    /**
     * 查询所有的内容
     */
    public List<Informations> getAll();

    /**
     * 根据id，查询指定的一条数据
     * @param id
     * @return
     */
    public Informations getOne(int id);

    public int updateReplyCount(int id);

    public int addOne(Informations informations) throws SQLException;
}
