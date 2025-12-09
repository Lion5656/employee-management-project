package com.myproject.service.impl;


import com.myproject.mapper.EmpLogMapper;
import com.myproject.pojo.EmpLog;
import com.myproject.service.EmpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpLogServiceImpl implements EmpLogService {

    @Autowired // 依賴注入DI
    private EmpLogMapper empLogMapper;

    // 新增員工日誌記錄，不管外部是否有事務都直接創建新事務
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void insertLog(EmpLog empLog) {
        empLogMapper.insert(empLog);
    }
}
