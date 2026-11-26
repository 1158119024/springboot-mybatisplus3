package com.xiaofeng.mybatisplus3_1.springbootmybatisplus3_1;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import com.xiaofeng.plus.SpringbootMybatisplus31Application;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootMybatisplus31Application.class)
@EnableAutoConfiguration
public class RSATest {


	@Autowired
	private StringEncryptor stringEncryptor;

	public static void main(String[] args) throws Exception {
	}

}
