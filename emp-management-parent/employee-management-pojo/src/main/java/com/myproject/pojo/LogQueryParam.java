package com.myproject.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogQueryParam {
    private String methodName; // 操作方法名

    private Integer page = 1; // 分頁頁碼，默認值1
    private Integer pageSize = 10; // 分頁資料數量，默認值10
}
