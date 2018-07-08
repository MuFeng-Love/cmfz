package com.baizhi.cmfz.util;
import cn.afterturn.easypoi.handler.impl.ExcelDataHandlerDefaultImpl;
import com.baizhi.cmfz.entity.Master;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: cmfz
 * @description: 上师批量插入
 * @author: wch
 * @create: 2018-07-07 14:52
 **/
public class MasterExcelHandler extends ExcelDataHandlerDefaultImpl<Master>{
    private static final Logger log = LoggerFactory.getLogger(MasterExcelHandler.class);

    @Override
    public Object importHandler(Master obj, String name, Object value) {
        log.info(name + ":" + value);
        return super.importHandler(obj, name, value);
    }

}
