package com.myproject.service.impl;

import com.myproject.mapper.EmpMapper;
import com.myproject.pojo.JobOption;
import com.myproject.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
/**
 * 統計表實體Service類
 */
@Service
public class ReportServiceImpl implements ReportService {
    @Autowired // DI 依賴注入
    private EmpMapper empMapper;

    @Override
    public JobOption getEmpJobData(){
        List<Map<String, Object>> list = empMapper.countByJob();
        List jobList = list.stream().map(data -> data.get("pos")).toList();
        List dataList = list.stream().map(data -> data.get("total")).toList();
        return new JobOption(jobList, dataList);
    }

    @Override
    public List<Map<String, Object>> getEmpGenderData(){
        List<Map<String, Object>> list = empMapper.countByGender();
        return list;
    }
}
