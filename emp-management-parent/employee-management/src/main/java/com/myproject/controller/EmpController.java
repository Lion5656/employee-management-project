package com.myproject.controller;

import com.myproject.anno.Log;
import com.myproject.pojo.Emp;
import com.myproject.pojo.EmpQueryParam;
import com.myproject.pojo.PageResult;
import com.myproject.pojo.Result;
import com.myproject.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * 員工實體Controller類
 */
@Slf4j
@RequestMapping("/emps") // 通用路徑前綴
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;
    /**
     * 分頁查詢所有員工列表
     * @param empQueryParam 員工查詢參數
     * @return Result包含員工列表
     */
    @Log
    @GetMapping
    public Result page(EmpQueryParam empQueryParam){
        log.info("分頁查詢所有員工列表參數: {}", empQueryParam);
        PageResult<Emp> pageList = empService.findPage(empQueryParam);
        return Result.success(pageList);
    }
    /**
     * 新增員工資料和工作經歷
     * @param emp 員工實體
     * @return Result無資料參數
     */
    @Log
    @PostMapping
    public Result save(@RequestBody Emp emp) {
        log.info("新增員工資料和工作經歷: {}", emp);
        empService.save(emp);
        return Result.success();
    }
    /**
     * 刪除員工資料和工作經歷
     * @param ids 員工id列表
     * @return Result無資料參數
     */
    @Log
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids){
        log.info("刪除員工資料: {}", ids);
        empService.deleteByIds(ids);
        return Result.success();
    }
    /**
     * 根據id查詢員工資料和工作經歷
     * @param id 員工id
     * @return Result包含員工資料和工作經歷
     */
    @Log
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("查詢員工id: {}", id);
        Emp emp = empService.getInfo(id);
        return Result.success(emp);
    }
    /**
     * 更新員工和員工經歷
     * @param emp 員工實體
     * @return Result無資料參數
     */
    @Log
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("更新員工和員工經歷: {}", emp);
        empService.update(emp);
        return Result.success();
    }
}
