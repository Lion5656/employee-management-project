package com.myproject.mapper;

import com.myproject.pojo.Admin;
import com.myproject.pojo.ResetInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AdminMapper {
    /**
     * 根據帳號和密碼查詢管理員
     * @param account 帳號
     * @param password 密碼
     * @return Admin 管理員資訊
     */
    @Select("select id, account from admin where account = #{account} and password = #{password}")
    Admin findByAccountAndPassword(String account, String password);
    /**
     * 根據帳號查詢管理員
     * @param account 帳號
     * @return String 管理員帳號
     */
    @Select("select account from admin where account = #{account}")
    String findByAccount(String account);
    /**
     * 根據ID查詢管理員帳號
     * @param id 管理員ID
     * @return Admin 管理員帳號
     */
    @Select("select account from admin where id = #{id}")
    Admin findById(Integer id);
    /**
     * 根據帳號更新密碼
     * @param info 重設資訊包含帳號和新密碼
     */
    @Update("update admin set password = #{password} where account = #{account}")
    void updateByAccount(ResetInfo info);
}
