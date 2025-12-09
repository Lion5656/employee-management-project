package com.myproject.service.impl;

import com.myproject.service.EmailService;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendEmail(String email) {
        String toUrl = "http://localhost:8080/reset?email=" + email;
        String htmlContent = "<html>" +
                "<body>" +
                "<h3>請點擊以下連結重設密碼:</h3>" +
                "<a href=\"" + toUrl + "\">重設密碼</a>" +
                "</body>" +
                "</html>";
        try{
            // 攜帶附件html郵件
            MimeMessage msg = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(msg, true, "UTF-8");
            helper.setTo(email);
            helper.setSubject("[專題]重設密碼郵件");
            helper.setText(htmlContent, true); // true表示內容是HTML格式

            mailSender.send(msg);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
