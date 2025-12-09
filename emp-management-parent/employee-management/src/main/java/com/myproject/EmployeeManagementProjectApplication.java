package com.myproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//@ServletComponentScan // 開啟Servlet組件支持
@SpringBootApplication
public class EmployeeManagementProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementProjectApplication.class, args);
    }

}
