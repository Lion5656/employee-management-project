package com.myproject.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
/**
 * 部門的實體資料類別
 */
@Data // 設置getter/setter
@NoArgsConstructor // 設置無參數建構子
@AllArgsConstructor // 設置全參數建構子
public class Dept {
    private Integer id;
    private String name;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
