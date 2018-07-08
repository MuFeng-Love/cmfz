package com.baizhi.cmfz.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import cn.afterturn.easypoi.handler.inter.IExcelDataHandler;
import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.service.MasterService;
import com.baizhi.cmfz.util.MasterExcelHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RequestMapping("/masPoi")
@Controller
public class MasterEasyPoiController {
    private static final Logger log = LoggerFactory.getLogger(MasterController.class);

    @Autowired
    private MasterService ms;

    @RequestMapping("/excelImport")
    @ResponseBody
    public String excelImport(MultipartFile file) {
        int resultTotal = 0;
        ImportParams importParams = new ImportParams();

        //数据处理
        IExcelDataHandler<Master> handler = new MasterExcelHandler();
        //对应Excel表格的列名,也是实体类对象执行的列名
        handler.setNeedHandlerFields(new String[]{"上师法名"});

        //验证
        importParams.setDataHandler(handler);

        try {
            ExcelImportResult<Master> result = ExcelImportUtil.importExcelMore(file.getInputStream(), Master.class, importParams);
            List<Master> successList = result.getList();
            List<Master> failList = result.getFailList();
            log.info("是否存在验证未通过的数据：" + result.isVerfiyFail());
            log.info("验证通过的数量" + successList.size());
            log.info("验证未通过的数量" + failList.size());

            for (Master master : successList) {
                log.info("成功列表信息" + master);
            }

            for (Master master : successList) {
                String uuidName = UUID.randomUUID().toString().replace("-", "");
                master.setMasterId(uuidName);
                System.out.println(master);
            }

            resultTotal = ms.addMasters(successList);

            for (Master master : failList) {
                log.info("失败列表信息" + master);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        if (resultTotal >= 1) {
            return "success";
        } else {
            return "error";
        }
    }
}
