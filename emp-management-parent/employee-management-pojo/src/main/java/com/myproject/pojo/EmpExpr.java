package com.myproject.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
/**
 * 員工工作經歷實體類
 */
@Data // 設置getter/setter
@NoArgsConstructor // 設置無參數建構子
@AllArgsConstructor // 設置全參數建構子
public class EmpExpr {
    private Integer id; //ID
    private Integer empId; //員工ID
    private LocalDate begin; //開始時間
    private LocalDate end; //結束時間
    private String company; //公司名稱
    private String job; //職位
}
