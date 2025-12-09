package com.myproject.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    private Integer id; // 管理員id
    private String account; // 管理員帳號
    private String password; // 管理員密碼
    private String token; // 驗證token
}
