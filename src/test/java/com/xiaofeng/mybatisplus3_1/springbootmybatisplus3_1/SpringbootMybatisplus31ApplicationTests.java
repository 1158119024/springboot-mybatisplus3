package com.xiaofeng.mybatisplus3_1.springbootmybatisplus3_1;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.xiaofeng.config.AESUtil;
import com.xiaofeng.plus.SpringbootMybatisplus31Application;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootMybatisplus31Application.class)
@EnableAutoConfiguration
public class SpringbootMybatisplus31ApplicationTests {


	@Autowired
	private StringEncryptor stringEncryptor;
	private static final Gson GSON = new Gson();
	@Test
	public void contextLoads() {
//		System.out.println(stringEncryptor.decrypt("oe66bPUR8JWgh5ytbRuw/A=="));;
//		System.out.println(stringEncryptor.decrypt("FKgNOWigXrzZs2VpZb3YiCXNWvTsViL0xKfCXiskcSXW5PO2XJKdqz9up5RrU9R3"));
//		System.out.println(stringEncryptor.decrypt("8FBNvh45LRziH8KhoMG0B4eEJP8srQkyf5amKnYjGKuOxFtVB7rzvEs959wJ1mm5"));
//		System.out.println(stringEncryptor.decrypt("pI1Wkw7BOcR45cffISXW09MMbjyIWh9NPvC3zCmjrPtAtSt1+ZcSELf/YkWhehhO"));
//		System.out.println(stringEncryptor.decrypt("cyHr2JJOi1ekt8mLE4RtPoAIkFx/rn8N46yuwbAUah9g//EyjxQxiSmNwFDU4jWj"));
//
//		System.out.println(stringEncryptor.encrypt("cmic_portal"));
//		System.out.println(stringEncryptor.decrypt("jw8mBu5o35DqBmw1NV8qftyiicIK2cr0kRoylUn4I8A3BD/ENPZo6gbOLlbJP6yv"));;
//		System.out.println(stringEncryptor.encrypt("yh85Duaf3K"));
//		System.out.println(stringEncryptor.decrypt("Pd6myEk6DyenGNpZ87qECcMQ/2j7kueoQGs4U9hj5mCzIJk7TYkpyL+u1Cd/76A1"));
//		System.out.println(stringEncryptor.decrypt("+H6VR4hnS7veQHL2CBJzVcUDIK8gynBNuRWl2bj00OlsMfvDteh2I3uXHdMo7kfg"));
//		System.out.println(stringEncryptor.encrypt("831a77f521b80252d33a6fb98ab3c1c6"));
//		System.out.println(stringEncryptor.decrypt("Dj7g55AkUZTwBKkYIWd/VxeSEagxBl5c"));
//		System.out.println(stringEncryptor.decrypt("pI1Wkw7BOcR45cffISXW09MMbjyIWh9NPvC3zCmjrPtAtSt1+ZcSELf/YkWhehhO"));
//		System.out.println(stringEncryptor.decrypt("cyHr2JJOi1ekt8mLE4RtPoAIkFx/rn8N46yuwbAUah9g//EyjxQxiSmNwFDU4jWj"));
//		System.out.println(stringEncryptor.decrypt("a13QsJXVJGW+TbGAkqfSBkXtTFd5jG24M7lE6o1WQsaQ1/CpALs4nymlGyzgPeMC"));
//		System.out.println(stringEncryptor.encrypt("c_vy1MgvHi"));
//		System.out.println(stringEncryptor.decrypt("1cgSR5fCrfEeLi7ESeiQHb1A0OJFQrcV"));

//		System.out.println(stringEncryptor.decrypt("iBkwIyHpNY0xeYewdNGyDvig/IpDbK/Yoed0azhzoBgw3NebS1kShh12Wyax/2VZsHlAFz350vSdt1Srz10uaQ=="));
//		System.out.println(stringEncryptor.decrypt("qej2ivWpDuh+aymGm1UmJHNyOqjDwKTpKBJeVXsTNJ4JteUzwYxUnPBBymmT3RbQawvwvCDhhV2SZmD8ZZdcGQ=="));


		System.out.println("appId:"+stringEncryptor.decrypt("FKgNOWigXrzZs2VpZb3YiCXNWvTsViL0xKfCXiskcSXW5PO2XJKdqz9up5RrU9R3"));
		System.out.println("appToken:"+stringEncryptor.decrypt("2GVi9LQ2W9N6QtxJ0l5+PzUpW/iY1qK8uszyreCdFyBWWksOuwnvUWg2Bd27YLru"));
		System.out.println("消息接入签名验证 token:"+stringEncryptor.decrypt("Ri29j9x6y3IBg6xrQKMk1R6wz5Ln/5syPKXwlrY7ATw="));
//		System.out.println(stringEncryptor.decrypt("Q1TE1lmZtOATsV/BfUhcma+H4JgWHiBNe0BnJLEC76TmbVsaeD043CDKHQWHEvxH"));
//		System.out.println(stringEncryptor.decrypt("cyHr2JJOi1ekt8mLE4RtPoAIkFx/rn8N46yuwbAUah9g//EyjxQxiSmNwFDU4jWj"));
	}

	public static void main(String[] args) throws Exception {
		// 构建

//		String lat = aes.decryptStr("+h/myacfqSL2X20JAxM57hrLR1nfIysJmdNcCYSAExg=");
//		System.out.println(lat);
//		String lng = aes.decryptStr("OBOJoZYnnfetAzfAmjKirgtfqoKNplSBNPG7ijUegd8=");
//		System.out.println(lng);
//
//		String lat1 = aes.decryptStr("ee3e4cf62015ed9c187f108f511051d8d12db1e4b8dd3dcc4446e70c192166d4");
//		System.out.println(lat1);
//		String lng1 = aes.decryptStr("b2eba8fa8e941707c0fa0d4e1c8ff3f90574e8c2b65cdb4ae707b5fdd82b9150");
//		System.out.println(lng1);
//
//		String lat2 = aes.decryptStr("+h/myacfqSL2X20JAxM57hrLR1nfIysJmdNcCYSAExg=");
//		System.out.println(lat2);
//		String lng2 = aes.decryptStr("OBOJoZYnnfetAzfAmjKirgtfqoKNplSBNPG7ijUegd8=");
//		System.out.println(lng2);
//
//		// "lat":"7VBBzOIqfz2pKwwxiS6Lkh8hvzGSd1c/OW7GjaqH2zQ=","lng":"nvX4dcUO4CwJ/4cKLFqgsKCGV9O1rV46qDFyYKDDhJs="
//		String lat3 = aes.decryptStr("7VBBzOIqfz2pKwwxiS6Lkh8hvzGSd1c/OW7GjaqH2zQ=");
//		System.out.println(lat3);
//		String lng3 = aes.decryptStr("nvX4dcUO4CwJ/4cKLFqgsKCGV9O1rV46qDFyYKDDhJs=");
//		System.out.println(lng3);
//
//		//"lat":"+h/myacfqSL2X20JAxM57hrLR1nfIysJmdNcCYSAExg=","lng":"OBOJoZYnnfetAzfAmjKirgtfqoKNplSBNPG7ijUegd8="
//		String lat4 = aes.decryptStr("+h/myacfqSL2X20JAxM57hrLR1nfIysJmdNcCYSAExg=");
//		System.out.println(lat4);
//		String lng4 = aes.decryptStr("OBOJoZYnnfetAzfAmjKirgtfqoKNplSBNPG7ijUegd8=");
//		System.out.println(lng4);
//
//		//"lat":"+h/myacfqSL2X20JAxM57hrLR1nfIysJmdNcCYSAExg=","lng":"OBOJoZYnnfetAzfAmjKirgtfqoKNplSBNPG7ijUegd8="
//		String lat5 = aes.decryptStr("+h/myacfqSL2X20JAxM57hrLR1nfIysJmdNcCYSAExg=");
//		System.out.println(lat5);
//		String lng5 = aes.decryptStr("OBOJoZYnnfetAzfAmjKirgtfqoKNplSBNPG7ijUegd8=");
//		System.out.println(lng5);

		//门口 "lat":"7VBBzOIqfz2pKwwxiS6Lkh8hvzGSd1c/OW7GjaqH2zQ=","lng":"nvX4dcUO4CwJ/4cKLFqgsKCGV9O1rV46qDFyYKDDhJs="

		//充电桩 "lat":"7VBBzOIqfz2pKwwxiS6Lkh8hvzGSd1c/OW7GjaqH2zQ=","lng":"nvX4dcUO4CwJ/4cKLFqgsKCGV9O1rV46qDFyYKDDhJs="

		//公司 "lat":"+h/myacfqSL2X20JAxM57hrLR1nfIysJmdNcCYSAExg=","lng":"OBOJoZYnnfetAzfAmjKirgtfqoKNplSBNPG7ijUegd8="

		List<String> list = Arrays.asList("13418718654", "13418718651");

		String valueStr = GSON.toJson(list);

		String s = JSON.toJSONString(list);
		System.out.println(valueStr+ "----" + s);


	}

}
