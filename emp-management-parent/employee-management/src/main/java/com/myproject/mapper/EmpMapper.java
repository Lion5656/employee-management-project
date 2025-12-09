package com.myproject.mapper;

import com.myproject.pojo.Emp;
import com.myproject.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * 員工Mapper
 * //    // mybatis 根據select的SQL語句查詢總員工資料記錄數
 * //    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id")
 * //    public Long count();
 * //
 * //    // mybatis 根據select的SQL語句查詢分頁展示資料
 * //    @Select("select e.*, d.name deptName from emp e left join dept d on e.dept_id = d.id " +
 * //            "order by e.update_time desc limit #{start}, #{pageSize}")
 * //    public List<Emp> list(@Param("start") Integer start, @Param("pageSize") Integer pageSize);
 */
@Mapper
public interface EmpMapper {
    // 這裡使用PageHelper根據映射的xml配置根據前台條件查詢所有員工資料
    List<Emp> list(EmpQueryParam empQueryParam);

    // 返回主鍵值->員工經歷
    @Options(useGeneratedKeys = true, keyProperty = "id")
    // mybatis 根據insert的SQL語句新增員工資料
    @Insert("insert into emp(name, gender, phone, job, salary, entry_date, dept_id, create_time, update_time) " +
            "values(#{name}, #{gender}, #{phone}, #{job}, #{salary}, #{entryDate}, #{deptId}, #{createTime}, #{updateTime})")
    void insert(Emp emp);

    // mybatis 根據delete的SQL語句刪除員工資料
    void deleteByIds(List<Integer> empIdList);

    // mybatis 根據id利用select的SQL語句查詢返回員工資料
    Emp getById(Integer id);

    // mybatis 根據id利用update的SQL語句更新員工資料
    void updateById(Emp emp);
    /**
     * 根據職位統計員工人數
     * @return List<Map<String, Object>> 職位統計列表
     */
    @MapKey("pos")
    List<Map<String, Object>> countByJob();

    /**
     * 根據性別統計員工人數
     * @return List<Map<String, Object>> 性別統計列表
     */
    @MapKey("name")
    List<Map<String, Object>> countByGender();
}
