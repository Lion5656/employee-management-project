package com.myproject.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OperateLog {
    private Integer id; // 日誌編號
    private Integer operateId; // 操作人ID
    private LocalDateTime operateTime; // 操作者時間
    private String className; // 操作類名
    private String methodName; // 操作方法名
    private String methodParams; // 方法參數
    private String returnValue; // 返回值
    private double costTime; // 耗時(seconds)

    private String operateAccount; // 操作管理員帳號
}
