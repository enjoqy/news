package org.zhu.service;

import org.zhu.domain.Informations;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author junhi
 * @Date 2019/5/27 15:11
 */
public interface InformationsService {

    public List<Informations> getAll();

    public Informations getOne(int id);

    public int updateReplyCount(int id);

    public int addOne(Informations informations) throws SQLException;
}
