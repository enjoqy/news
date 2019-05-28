package org.zhu.service.impl;

import org.zhu.dao.InformationsDao;
import org.zhu.dao.impl.InformationsDaoImpl;
import org.zhu.domain.Informations;
import org.zhu.service.InformationsService;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author junhi
 * @Date 2019/5/27 15:11
 */
public class InformationsServiceImpl implements InformationsService {

    private InformationsDao informationsDao = new InformationsDaoImpl();

    /**
     * 获取表中所有的数据
     * @return
     */
    @Override
    public List<Informations> getAll() {
        return informationsDao.getAll();
    }

    /**
     * 获取表中指定的一条数据
     * @param id
     * @return
     */
    @Override
    public Informations getOne(int id) {
        return informationsDao.getOne(id);
    }

    /**
     * 更新查看次数+1
     */
    @Override
    public int updateReplyCount(int id) {
        return  informationsDao.updateReplyCount(id);
    }

    /**
     * 增加一条数据
     * @param informations
     */
    @Override
    public int addOne(Informations informations) throws SQLException {
        return  informationsDao.addOne(informations);
    }
}
