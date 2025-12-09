package com.myproject.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 職位統計封裝實體類
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobOption {
    private List jobList; // 職位列表
    private List dataList; // 職位人數列表
}
