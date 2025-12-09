package com.myproject.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.myproject.mapper.AttdRecordMapper;
import com.myproject.pojo.AttdRecord;
import com.myproject.pojo.AttdRecordQueryParam;
import com.myproject.pojo.PageResult;
import com.myproject.service.AttdRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttdRecordServiceImpl implements AttdRecordService {
    @Autowired // DI 依賴注入
    private AttdRecordMapper attdRecordMapper;
    /**
     * 分頁查詢出勤紀錄
     * @param a 出勤紀錄查詢參數
     * @return PageResult 包含出勤紀錄列表
     */
    @Override
    public PageResult<AttdRecord> findPage(AttdRecordQueryParam a){
        // 使用PageHelper進行分頁查詢
        PageHelper.startPage(a.getPage(), a.getPageSize());
        // 取得出勤紀錄列表
        List<AttdRecord> recordList = attdRecordMapper.list(a);
        Page<AttdRecord> pageList = (Page) recordList;
        return new PageResult<AttdRecord>(pageList.getTotal(), pageList.getResult());
    }
    /**
     * 根據id刪除出勤紀錄
     * @param ids 出勤紀錄id
     */
    @Override
    public void deleteByIds(List<Integer> ids){
        // 調用Mapper刪除出勤紀錄
        attdRecordMapper.deleteByIds(ids);
    }
}
