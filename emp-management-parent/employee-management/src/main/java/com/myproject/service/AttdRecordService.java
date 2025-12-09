package com.myproject.service;

import com.myproject.pojo.AttdRecord;
import com.myproject.pojo.AttdRecordQueryParam;
import com.myproject.pojo.PageResult;

import java.util.List;

/**
 * 出勤記錄Service介面
 */
public interface AttdRecordService {
    PageResult<AttdRecord> findPage(AttdRecordQueryParam a);

    void deleteByIds(List<Integer> ids);
}
