package com.myproject.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpLog {
    private Integer id; // ID ，主鍵
    private LocalDateTime operateTime; // 操作時間
    private String info; // 操作資訊
}
