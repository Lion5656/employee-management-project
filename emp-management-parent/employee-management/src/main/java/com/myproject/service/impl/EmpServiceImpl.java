package com.myproject.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.myproject.mapper.AttdRecordMapper;
import com.myproject.mapper.EmpExprMapper;
import com.myproject.mapper.EmpMapper;
import com.myproject.pojo.*;
import com.myproject.service.EmpLogService;
import com.myproject.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 員工實體Service類
 * //    @Override
 * //    public PageResult<Emp> findPage(Integer page, Integer pageSize){
 * //        // 查詢總資料數
 * //        Long total = empMapper.count();
 * //        // 查詢員工分頁展示資料
 * //        Integer start = (page - 1) * pageSize;
 * //        List<Emp> empList = empMapper.list(start, pageSize);
 * //        // 回傳封裝結果
 * //        return new PageResult<Emp>(total, empList);
 * //    }
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired // 依賴注入DI
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;

    @Autowired
    private EmpLogService empLogService;

    @Autowired
    private AttdRecordMapper attdRecordMapper;
    /**
     * 使用PageHelper進行分頁查詢員工列表
     *
     * @param empQueryParam 員工查詢參數
     * @return PageResult封裝分頁展示結果
     */
    @Override
    public PageResult<Emp> findPage(EmpQueryParam empQueryParam) {
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());
        // 查詢員工分頁展示資料
        List<Emp> empList = empMapper.list(empQueryParam);
        // 轉換為Page物件
        Page<Emp> empPage = (Page<Emp>) empList;
        // 回傳封裝結果
        return new PageResult<Emp>(empPage.getTotal(), empPage.getResult());
    }
    /**
     * 新增員工資料和工作經歷
     * @param emp 員工實體
     */
    // 開啟事務管理，默認運行時異常rollback，這裡設置所有異常都回滾
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void save(Emp emp) {
        try {
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            // 新增員工資料
            empMapper.insert(emp);

            // 新增工作經歷
            List<EmpExpr> exprList = emp.getExprList();
            if (!CollectionUtils.isEmpty(exprList)) {
                for (EmpExpr expr : exprList) {
                    expr.setEmpId(emp.getId());
                }
                empExprMapper.insertBatch(exprList);
            }
        }
        // 無論操作成功失敗都記錄日誌
        finally {
            EmpLog empLog = new EmpLog(null, LocalDateTime.now(), "新增員工: " + emp);
            empLogService.insertLog(empLog);
        }
    }
    /**
     * 根據id刪除員工資料和相關工作經歷和出勤紀錄
     * @param empIdList 員工id列表
     */
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void deleteByIds(List<Integer> empIdList){
        // 批量刪除員工資料
        empMapper.deleteByIds(empIdList);

        // 刪除員工相關工作經歷資料
        empExprMapper.deleteByEmpIds(empIdList);

        // 刪除員工相關出勤紀錄資料
        attdRecordMapper.deleteByEmpIds(empIdList);
    }
    /**
     * 根據id查詢員工資料和工作經歷
     * @param id 員工id
     * @return Emp包含員工資料和工作經歷
     */
    @Override
    public Emp getInfo(Integer id){
       Emp emp = empMapper.getById(id);
       return emp;
    }
    @Override
    public void update(Emp emp){
        // 更新updateTime
        emp.setUpdateTime(LocalDateTime.now());
        // 更新員工資料
        empMapper.updateById(emp);
        // 刪除原有工作經歷
        empExprMapper.deleteByEmpIds(List.of(emp.getId()));
        // 新增工作經歷
        List<EmpExpr> exprList = emp.getExprList();
        if(!CollectionUtils.isEmpty(exprList)){
            exprList.forEach(expr -> expr.setEmpId(emp.getId()));
            empExprMapper.insertBatch(exprList);
        }
    }
}
