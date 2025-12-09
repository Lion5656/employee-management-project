package com.myproject.controller;

import com.myproject.anno.Log;
import com.myproject.pojo.Dept;
import com.myproject.pojo.Result;
import com.myproject.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * 部門實體Controller類
 */
@Slf4j
@RequestMapping("/depts") // 通用路徑前綴
@RestController // 包含@Controller + @ResponseBody
public class DeptController {
    @Autowired // DI 依賴注入
    private DeptService deptService;
    /**
     * 查詢所有部門列表
     * @return Result包含部門列表
     */
    @GetMapping
    public Result list() {
        log.info("查詢所有部門列表");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }
    /**
     * 刪除部門
     * @return Result無資料參數
     */
    @Log
    @DeleteMapping
    public Result delete(@RequestParam("id") Integer id){
        log.info("刪除部門id: {}", id);
        deptService.deleteById(id);
        return Result.success();
    }
    /**
     * 新增部門
     * @return Result無資料參數
     */
    @Log
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("新增部門: {}", dept);
        deptService.add(dept);
        return Result.success();
    }
    /**
     * 根據id查詢部門
     * @return Result包含部門資料
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable("id") Integer deptId){
        log.info("根據id查詢部門id: {}", deptId);
        Dept dept = deptService.getById(deptId);
        return Result.success(dept);
    }
    /**
     * 根據id修改部門名稱
     * @return Result無資料參數
     */
    @Log
    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("修改部門: {}", dept);
        deptService.update(dept);
        return Result.success();
    }
}
