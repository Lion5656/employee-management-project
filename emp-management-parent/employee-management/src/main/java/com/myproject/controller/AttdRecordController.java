package com.myproject.controller;

import com.myproject.anno.Log;
import com.myproject.pojo.AttdRecord;
import com.myproject.pojo.AttdRecordQueryParam;
import com.myproject.pojo.PageResult;
import com.myproject.pojo.Result;
import com.myproject.service.AttdRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/records")
@RestController
public class AttdRecordController {

    @Autowired // DI 依賴注入
    private AttdRecordService attdRecordService;
    /**
     * 分頁查詢所有出勤記錄列表
     * @param a 出勤紀錄查詢參數
     * @return Result 包含出勤紀錄列表
     */
    @Log
    @GetMapping
    public Result page(AttdRecordQueryParam a){
        log.info("分頁查詢出勤紀錄參數: {}", a);
        PageResult<AttdRecord> pageList = attdRecordService.findPage(a);
        return Result.success(pageList);
    }
    /**
     * 根據id刪除出勤記錄
     * @param ids 出勤紀錄id
     * @return Result 無資料參數
     */
    @Log
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids){
        log.info("刪除出勤記錄id: {}", ids);
        attdRecordService.deleteByIds(ids);
        return Result.success();
    }
}
