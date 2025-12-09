package com.myproject.pojo;

import lombok.Data;
/**
 * 後端統一返回的結果
 */
@Data
public class Result {
    private Integer code; // 代碼: 1成功, 0失敗
    private String msg; // 錯誤訊息
    private Object data; // 回傳資料
    // 無攜帶資料的成功回應
    public static Result success(){
        Result result = new Result();
        result.code = 1;
        result.msg = "success";
        return result;
    }
    // 有攜帶資料的成功回應
    public static Result success(Object obj){
        Result result = new Result();
        result.code = 1;
        result.data = obj;
        result.msg = "success";
        return result;
    }
    // 錯誤回應
    public static Result error(String msg){
        Result result = new Result();
        result.code = 0;
        result.msg = msg;
        return result;
    }
}
