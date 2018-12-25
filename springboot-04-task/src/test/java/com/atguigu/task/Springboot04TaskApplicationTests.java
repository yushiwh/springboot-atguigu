package com.atguigu.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot04TaskApplicationTests {

	@Autowired
	JavaMailSenderImpl mailSender;

	@Test
	public void contextLoads() {
		SimpleMailMessage message = new SimpleMailMessage();
		//邮件设置
		message.setSubject("通知-今晚开会");
		message.setText("今晚7:30开会");

		message.setTo("9******4@qq.com");
		message.setFrom("y******h@126.com");

		mailSender.send(message);
	}

	@Test
	public void test02() throws  Exception{
		//1、创建一个复杂的消息邮件
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

		//邮件设置
		helper.setSubject("通知-今晚开会-测试一下邮件发送");
		helper.setText("<b style='color:red'>今天 7:30 开会</b>",true);

		helper.setTo("2******0@qq.com");
		helper.setFrom("y******h@126.com");

		//上传文件
		helper.addAttachment("1.jpg",new File("C:\\103第一学期课程表.jpg"));
		helper.addAttachment("2.png",new File("C:\\1.png"));

		mailSender.send(mimeMessage);

	}

}
