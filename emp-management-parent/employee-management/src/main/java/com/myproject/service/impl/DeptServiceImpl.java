package com.myproject.service.impl;

import com.myproject.pojo.Dept;
import com.myproject.mapper.DeptMapper;
import com.myproject.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
/**
 * 部門實體Service類
 */
@Service // 將service實現類放到IoC容器
public class DeptServiceImpl implements DeptService {

    @Autowired // DI 依賴注入
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findAll(){
        List<Dept> deptList = deptMapper.findAll();
        return deptList;
    }

    @Override
    public void deleteById(Integer id){
        deptMapper.deleteById(id);
    }

    @Override
    public void add(Dept dept){
        // 這裡可以添加一些業務邏輯，例如檢查部門名稱是否已存在等
        // 目前僅為示範，直接調用Mapper進行插入操作
        // 假設DeptMapper中有一個insert方法
        // 補全基礎屬性createTime, updateTime
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    @Override
    public Dept getById(Integer id){
        Dept dept = deptMapper.getById(id);
        return dept;
    }

    @Override
    public void update(Dept dept){
        // 補全updateTime
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.updateById(dept);
    }
}
