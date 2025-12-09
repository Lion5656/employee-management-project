package com.myproject.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttdRecordQueryParam {
    private Integer empId; // 員工ID

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin; // 查詢起始日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end; // 查詢結束日期

    private Integer page = 1; // 分頁頁碼，默認1
    private Integer pageSize = 10; // 分頁資料數，默認10
}
