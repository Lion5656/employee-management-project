package com.myproject.utils;

import lombok.extern.slf4j.Slf4j;

/**
 * 獲取當前線程相關資訊的工具類
 */
public class CurrentHolder {

    private static ThreadLocal<Integer> CURRENT_LOCAL =  new ThreadLocal<>();
    /**
     * 在ThreadLocal中設置管理員id
     * @param adminId 管理員id
     */
    public static void setCurrentId(Integer adminId){
        CURRENT_LOCAL.set(adminId);
    }
    /**
     * 在ThreadLocal中取得管理員id
     * @return CurrentHolder中管理員id
     */
    public static Integer getCurrentId(){
        return CURRENT_LOCAL.get();
    }
    /**
     *  在ThreadLocal中移除管理員id
     */
    public static void removeCurrentId(){
        CURRENT_LOCAL.remove();
    }
}
