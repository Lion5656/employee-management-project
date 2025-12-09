package com.myproject.mapper;

import com.myproject.pojo.LogQueryParam;
import com.myproject.pojo.OperateLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OperateLogMapper {
    // 基於mybatis新增操作日誌
    @Insert("insert into operate_log(operate_id, operate_time, class_name, method_name, method_params, return_value, cost_time) " +
            "values(#{operateId}, #{operateTime}, #{className}, #{methodName}, #{methodParams}, #{returnValue}, #{costTime})")
    void insert(OperateLog operateLog);

    // 這裡使用PageHelper根據映射的xml配置根據前台條件查詢所有日誌資料
    List<OperateLog> list(LogQueryParam logQueryParam);
}
