package com.myproject.service.impl;

import com.myproject.mapper.AdminMapper;
import com.myproject.pojo.Admin;
import com.myproject.pojo.LogInfo;
import com.myproject.pojo.ResetInfo;
import com.myproject.service.AdminService;
import com.myproject.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myproject.exception.InvalidLoginException;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired // DI 依賴注入
    private AdminMapper adminMapper;
    /**
     * * 管理員登入服務
     * @param admin 管理員實體包含帳號密碼
     * @return 管理員資訊
     */
    @Override
    public LogInfo login(Admin admin) {
        String account = admin.getAccount();
        String password = admin.getPassword();
        // 調用Mapper方法查詢管理員
        Admin a = adminMapper.findByAccountAndPassword(account, password);
        if(a != null){
            log.info("管理員登入成功, {}", account);
            // 生成Jwt
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("id", a.getId()); // id必須放
            dataMap.put("account", a.getAccount());
            String jwt = JwtUtils.generateJwt(dataMap);
            return new LogInfo(a.getId(), a.getAccount(), jwt);
        }

        if(adminMapper.findByAccount(account) == null){
            log.warn("登入失敗, 帳號不存在");
            throw new InvalidLoginException("帳號不存在");
        }
        else{
            log.warn("登入失敗, 帳號或密碼錯誤");
            throw new InvalidLoginException("帳號或密碼錯誤");
        }
    }
    /**
     * 根據ID查詢管理員帳號
     * @param id
     * @return String 管理員帳號
     */
    public String findAccountById(Integer id){
        Admin admin = adminMapper.findById(id);
        if(admin != null){
            return admin.getAccount();
        }
        return null;
    }
    /**
     * 重設密碼
     * @param info 重設資訊包含帳號和新密碼
     */
    @Override
    public void reset(ResetInfo info){
        adminMapper.updateByAccount(info);
        log.info("重設密碼成功, account: {}", info.getAccount());
    }
}
