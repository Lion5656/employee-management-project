package com.myproject.mapper;

import com.myproject.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 部門Mapper
 */
@Mapper // MyBatis映射，執行時自動創建實現類將其放置到IoC容器
public interface DeptMapper {
    // mybatis根據select的SQL語句查詢返回結果
    @Select("select id, name, create_time, update_time from dept order by update_time desc;")
    List<Dept> findAll();

    // mybatis根據delete的SQL語句刪除數據
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    // mybatis根據insert的SQL語句刪除數據
    @Insert("insert into dept(name, create_time, update_time) values(#{name}, #{createTime}, #{updateTime})")
    void insert(Dept dept);

    // mybatis根據id利用select的SQL語句查詢返回結果
    @Select("select id, name, create_time, update_time from dept where id = #{id}")
    Dept getById(Integer id);

    // mybatis根據id利用update的SQL語句更新數據
    @Update("update dept set name = #{name}, update_time = #{updateTime} where id = #{id}")
    void updateById(Dept dept);
}
