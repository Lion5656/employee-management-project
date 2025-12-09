package com.myproject.service;

import com.myproject.pojo.Emp;
import com.myproject.pojo.EmpQueryParam;
import com.myproject.pojo.PageResult;

import java.util.List;
/**
 * 員工Service介面
 */
public interface EmpService {
    PageResult<Emp> findPage(EmpQueryParam empQueryParam);

    void save(Emp emp);

    void deleteByIds(List<Integer> ids);

    Emp getInfo(Integer id);

    void update(Emp emp);
}
