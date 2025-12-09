package com.myproject.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 重設密碼封裝實體類
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResetInfo {
    private String account; // 使用者帳號
    private String password; // 新密碼
}
