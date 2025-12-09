package com.myproject.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
/**
 * 員工條件分頁查詢參數實體類
 */
@Data // 設置getter/setter
@NoArgsConstructor // 設置無參數建構子
@AllArgsConstructor // 設置全參數建構子
public class EmpQueryParam {
    private String name; // 員工姓名
    private Integer gender; // 員工性別

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin; // 入職開始日期

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end; // 入職結束日期

    private Integer page = 1; // 分頁頁碼，默認值1
    private Integer pageSize = 10; // 分頁資料數量，默認值10
}
