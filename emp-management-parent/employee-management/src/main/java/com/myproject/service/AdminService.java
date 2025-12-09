package com.myproject.service;

import com.myproject.pojo.Admin;
import com.myproject.pojo.LogInfo;
import com.myproject.pojo.ResetInfo;

/**
 * 管理員Service介面
 */
public interface AdminService {
    LogInfo login(Admin admin);

    void reset(ResetInfo info);
}
