package com.myproject.controller;

import com.myproject.pojo.LogQueryParam;
import com.myproject.pojo.OperateLog;
import com.myproject.pojo.PageResult;
import com.myproject.pojo.Result;
import com.myproject.service.OperateLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 操作日誌Controller
 */
@Slf4j
@RequestMapping("/log")
@RestController
public class OperateLogController {
    @Autowired
    private OperateLogService operateLogService;
    /**
     * 分頁查詢操作日誌
     * @param logQueryParam 操作日誌查詢參數
     * @return Result包含操作日誌列表
     */
    @GetMapping
    public Result page(LogQueryParam logQueryParam){
        log.info("分頁查詢操作日誌列表參數: {}", logQueryParam);
        PageResult<OperateLog> pageList = operateLogService.findPage(logQueryParam);
        return Result.success(pageList);
    }
}
