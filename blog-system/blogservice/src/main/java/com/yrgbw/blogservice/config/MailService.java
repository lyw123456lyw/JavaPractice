package com.yrgbw.blogservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;

/**
 * @Author 江城
 * @Description TODO
 * @Date 2019/12/27 10:43
 **/
@Service
public class MailService {
    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private JavaMailSender sender;

    /**
     * @param sendTo  接收方的邮箱地址
     * @param subject 邮件标题
     * @param content 邮件内容
     */
    //发送简单邮件
    public void sendMail(String sendTo, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(subject);
        message.setTo(sendTo);
        message.setText(content);
        message.setFrom(from);

        sender.send(message);
    }

    /**
     *
     * @param sendTo 接收方的邮箱地址
     * @param subject 邮件标题
     * @param content 邮件内容
     * @throws MessagingException
     */
    //发送简单html邮件
    public void sendHtmlMail(String sendTo, String subject, String content) throws MessagingException {
        MimeMessage message = sender.createMimeMessage();

        //封装邮件格式内容
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(sendTo);
        helper.setSubject(subject);
        helper.setText(content, true);

        sender.send(message);

    }

    /**
     * @param sendTo       接收方的邮箱地址
     * @param subject      邮件标题
     * @param content      邮件内容
     * @param filePathList 附件地址集合
     * @throws MessagingException
     */
    //发送附件邮件，多附件
    public void sendAttachMail(String sendTo, String subject, String content, List<String> filePathList) throws MessagingException {
        MimeMessage message = sender.createMimeMessage();

        //封装邮件格式内容
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(sendTo);
        helper.setSubject(subject);
        helper.setText(content, true);

        //附件
        for (int i = 0; i < filePathList.size(); i++) {

            FileSystemResource resource = new FileSystemResource(new File(filePathList.get(i)));
            //获取文件名
            String fileName = resource.getFilename();
            //添加附件
            helper.addAttachment(fileName, resource);
        }
        sender.send(message);
    }
}