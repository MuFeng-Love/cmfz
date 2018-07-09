package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogDao {

    /**
     * @descroption 增加事务
     * @param log
     * @return
     */
    public Integer insertLog(Log log);

    public List<Log> selectAll(@Param("rowsNumber")Integer rowsNumber, @Param("pageSize") Integer pageSize);

    public int count();
}
