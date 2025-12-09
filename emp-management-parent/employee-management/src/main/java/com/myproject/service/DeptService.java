package com.myproject.service;

import com.myproject.pojo.Dept;

import java.util.List;
/**
 * 部門Service介面
 */
public interface DeptService {
     List<Dept> findAll();

     void deleteById(Integer id);

     void add(Dept dept);

     Dept getById(Integer id);

     void update(Dept dept);
}
