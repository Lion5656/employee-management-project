package com.myproject.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.myproject.mapper.OperateLogMapper;
import com.myproject.pojo.LogQueryParam;
import com.myproject.pojo.OperateLog;
import com.myproject.pojo.PageResult;
import com.myproject.service.OperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperateLogServiceImpl implements OperateLogService {
    @Autowired // 依賴注入DI
    private OperateLogMapper operateLogMapper;
    /**
     * 根據分頁查詢參數查詢操作日誌
     * @param logQueryParam 操作日誌查詢參數
     * @return PageResult 包含操作日誌列表和總數
     */
    @Override
    public PageResult<OperateLog> findPage(LogQueryParam logQueryParam) {
        // 設定PageHelper進行分頁查詢
        PageHelper.startPage(logQueryParam.getPage(), logQueryParam.getPageSize());
        // 查詢操作日誌展示分頁資料
        List<OperateLog> logList = operateLogMapper.list(logQueryParam);
        logList.forEach(log -> System.out.println(log));
        // 封裝返回分頁結果
        Page<OperateLog> page = (Page) logList;
        return new PageResult<OperateLog>(page.getTotal(), page.getResult());
    }
}
