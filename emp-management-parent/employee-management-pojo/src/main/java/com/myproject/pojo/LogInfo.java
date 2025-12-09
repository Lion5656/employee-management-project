package com.myproject.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 登入回應資訊封裝實體類
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogInfo {
    private Integer id; // 管理員id
    private String account; // 登入帳號
    private String token; // 驗證token
}
