package com.myproject.aop;

import com.myproject.mapper.OperateLogMapper;
import com.myproject.pojo.OperateLog;
import com.myproject.service.impl.AdminServiceImpl;
import com.myproject.utils.CurrentHolder;
import com.myproject.utils.MethodNameConverter;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * 操作日誌aop類
 */
@Slf4j
@Aspect
@Component
public class OperateLogAspect {

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Autowired
    private AdminServiceImpl adminServiceImpl;
    /**
     * 紀錄操作日誌切面
     * @param pjp 目標方法的切入點
     * @return Object 目標方法執行結果
     */
    @Around("@annotation(com.myproject.anno.Log)")
    public Object logOperation(ProceedingJoinPoint pjp) throws Throwable {
        // 紀錄開始時間
        long startTime = System.currentTimeMillis();

        // 執行目標方法
        Object result = pjp.proceed();
        // 紀錄結束時間
        long endTime = System.currentTimeMillis();
        // 計算消耗時間(seconds)
        double costTime = (endTime - startTime) / 1000.0;

        OperateLog operateLog = new OperateLog();
        operateLog.setOperateId(getCurrentOperatorId());
        operateLog.setOperateTime(LocalDateTime.now());
        operateLog.setClassName(pjp.getTarget().getClass().getSimpleName());
        // 轉換方法名稱
        String methodName = MethodNameConverter.convert(pjp.getTarget().getClass().getSimpleName(), pjp.getSignature().getName());
        operateLog.setMethodName(methodName);
        operateLog.setMethodParams(Arrays.toString(pjp.getArgs()));
        operateLog.setReturnValue(result != null ? result.toString() : "void");
        operateLog.setCostTime(costTime);
        operateLog.setOperateAccount(adminServiceImpl.findAccountById(getCurrentOperatorId()));

        log.info("新增操作日誌: {}", operateLog);
        // 新增操作日誌到資料庫
        operateLogMapper.insert(operateLog);

        return result;
    }

    public Integer getCurrentOperatorId() {
        return CurrentHolder.getCurrentId();
    }

}
