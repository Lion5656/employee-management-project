package com.myproject.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
/**
 * 回應前端分頁結果的實體類
 */
@Data // 設置getter/setter
@NoArgsConstructor // 設置無參數建構子
@AllArgsConstructor // 設置全參數建構子
public class PageResult<T> {
    private Long total; // 總記錄數
    private List<T> rows; // 當前分頁資料
}
