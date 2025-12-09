package com.myproject.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttdRecord {
    private Integer id; // 出勤記錄ID
    private Integer empId; // 員工ID
    private LocalDateTime checkInTime; // 上班打卡時間
    private LocalDateTime checkOutTime; // 下班打卡時間
    private LocalDate workDate; // 出勤日期
    private String status; // 出勤狀況: "正常", "遲到", "早退", "缺勤"
}
