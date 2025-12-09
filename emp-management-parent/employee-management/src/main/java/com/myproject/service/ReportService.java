package com.myproject.service;

import com.myproject.pojo.JobOption;

import java.util.List;
import java.util.Map;

/**
 * 統計表Service介面
 */
public interface ReportService {
    JobOption getEmpJobData();

    List<Map<String, Object>> getEmpGenderData();
}
