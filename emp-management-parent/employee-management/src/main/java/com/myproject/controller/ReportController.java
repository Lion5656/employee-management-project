package com.myproject.controller;

import com.myproject.pojo.JobOption;
import com.myproject.pojo.Result;
import com.myproject.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
/**
 * 統計圖表實體controller類
 */
@Slf4j
@RequestMapping("/report")
@RestController
public class ReportController {

    @Autowired // DI 依賴注入
    private ReportService reportService;
    /**
     * 查詢員工職位資料
     * @return Result包含職位統計資料
     */
    @GetMapping("/empJobData")
    public Result getEmpJobData(){
        log.info("查詢員工職位資料");
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);
    }
    /**
     *  查詢員工性別分布資料
     * @return Result包含性別的統計資料
     */
    @GetMapping("/empGenderData")
    public Result getEmpGenderData(){
        log.info("查詢員工性別資料");
        List<Map<String, Object>> genderMap = reportService.getEmpGenderData();
        return Result.success(genderMap);
    }
}
