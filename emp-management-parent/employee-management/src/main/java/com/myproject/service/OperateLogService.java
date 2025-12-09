package com.myproject.service;

import com.myproject.pojo.LogQueryParam;
import com.myproject.pojo.OperateLog;
import com.myproject.pojo.PageResult;

/**
 * 操作日誌Service介面
 */
public interface OperateLogService {
    PageResult<OperateLog> findPage(LogQueryParam logQueryParam);
}
