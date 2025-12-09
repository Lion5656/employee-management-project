package com.myproject.utils;

public class MethodNameConverter {

    public static String convert(String className, String methodName) {
        // 移除 "Impl" 後綴
        if (className.endsWith("Controller")) {
            className = className.substring(0, className.length() - 10);
        }
        // 將首字母轉小寫
        if (className.length() > 0) {
            className = className.substring(0, 1).toLowerCase() + className.substring(1);
        }
        // 將方法名轉換成中文
        String converted = "其他";
        if(methodName.matches("(get|page).*")){
            converted = "查詢資料";
        }
        else if(methodName.matches("(save|add).*")){
            converted = "新增資料";
        }
        else if(methodName.matches("update.*")){
            converted = "編輯資料";
        }
        else if(methodName.matches("delete.*")){
            converted = "刪除資料";
        }

        return converted;
    }
}
