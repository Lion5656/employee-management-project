package com.myproject.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 員工實體類
 */
@Data // 設置getter/setter
@NoArgsConstructor // 設置無參數建構子
@AllArgsConstructor // 設置全參數建構子
public class Emp {
    private Integer id; //'ID，主鍵'
    private String name; //姓名
    private Integer gender; //'性別，1：男，2：女'
    private String phone; //手機號
    private Integer job; // '職位，1 主任，2 組長，3 專員，4 員工，5 實習生'
    private Integer salary; //薪資
    private LocalDate entryDate; //入職日期
    private Integer deptId; //關聯的部門ID
    private LocalDateTime createTime; //創建時間
    private LocalDateTime updateTime; //更新時間
    private String deptName; //所屬部門名稱

    private List<EmpExpr> exprList; //員工經歷列表
}
