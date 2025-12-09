package com.myproject.controller;

import com.myproject.pojo.ResetInfo;
import com.myproject.pojo.Result;
import com.myproject.service.AdminService;
import com.myproject.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * 重設密碼Controller
 */
@Slf4j
@RequestMapping("/reset")
@RestController
public class PswResetController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private AdminService adminService;
    /**
     * 接收重設密碼請求
     * @param email 使用者郵箱
     * @return Result 無參數
     */
    @GetMapping("/{email}")
    public Result receive(@PathVariable String email){
        log.info("重設密碼, email: {}", email);
        emailService.sendEmail(email);
        return Result.success();
    }
    /**
     * 重設密碼
     * @param info 重設資訊包含帳號和新密碼
     * @return Result 無參數
     */
    @PostMapping
    public Result resetPassword(@RequestBody ResetInfo info){
        log.info("重設密碼, info: {}", info);
        adminService.reset(info);
        return Result.success();
    }

}
