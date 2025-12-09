package com.myproject.controller;

import com.myproject.pojo.Admin;
import com.myproject.pojo.LogInfo;
import com.myproject.pojo.Result;
import com.myproject.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 管理員登入Controller
 */
@Slf4j
@RequestMapping("/login")
@RestController
public class LogInController {

    @Autowired // DI 依賴注入
    private AdminService adminService;
    /**
     * 管理員登入
     * @param admin 管理員實體
     * @return Result包含登入資訊
     */
    @PostMapping
    public Result login(@RequestBody Admin admin){
        log.info("管理員登入中...");
        LogInfo logInfo = adminService.login(admin);
        return Result.success(logInfo);
    }
}
