package com.myproject.mapper;

import com.myproject.pojo.AttdRecord;
import com.myproject.pojo.AttdRecordQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AttdRecordMapper {
    // 根據PageHelper查詢出勤分頁
    List<AttdRecord> list(AttdRecordQueryParam a);

    // 根據員工id刪除出勤紀錄
    void deleteByEmpIds(List<Integer> empId);

    // 根據出勤記錄id刪除出勤紀錄
    void deleteByIds(List<Integer> ids);
}
