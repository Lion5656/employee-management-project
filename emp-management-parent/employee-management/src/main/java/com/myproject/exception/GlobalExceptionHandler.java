package com.myproject.exception;

import com.myproject.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/**
 * 全局異常處理器類別
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public Result handleException(Exception e){
        log.error("系統出現例外", e);
        return Result.error("伺服器出現異常~請重新再試!");
    }

    @ExceptionHandler
    public Result handleDuplicateKeyException(DuplicateKeyException e){
        log.error("系統出現例外 {}", e);
        String msg = e.getMessage();
        int i = msg.indexOf("Duplicate entry");
        String errMsg = msg.substring(i);
        String[] arr = errMsg.split(" ");
        return Result.error( arr[2] + " 已存在, 請修改後重新再試!");
    }

    @ExceptionHandler
    public Result handleIllegalCharacterException(InvalidCharacterException e){
        log.error("系統出現例外 {}", e);
        return Result.error("輸入中包含非法字元，請重新再試!");
    }

    @ExceptionHandler
    public Result handleInvalidLoginException(InvalidLoginException e){
        log.error("系統出現例外 {}", e);
        return Result.error(e.getMessage());
    }
}
