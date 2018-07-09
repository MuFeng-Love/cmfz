package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Master;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MasterDao {
    public List<Master> findAllMasters(@Param("rowsNumber")Integer rowsNumber, @Param("pageSize") Integer pageSize);

    public Master findMasterById(String masterId);

    public Integer deleteMaster(String masterId);

    public Integer updateMaster(Master master);

    public Integer insertMasters(@Param("masters") List<Master> masters);

    public Integer count();

    public List<Master> findSomeMasters(@Param("value") String value, @Param("name") String name,@Param("rowsNumber")Integer rowsNumber, @Param("pageSize")Integer pageSize);

    public Integer count1(@Param("value") String value, @Param("name") String name);

    public Integer insertMaster(Master master);

    public List<Master> findMasters();
}
