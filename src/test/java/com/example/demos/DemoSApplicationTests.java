package com.example.demos;

import com.example.demos.dao.UserInfoRepository;
import com.example.demos.model.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoSApplicationTests {

	@Autowired
	private UserInfoRepository userInfoRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void throughSql() {
		List<UserInfo> res1=userInfoRepository.findThroughSql("m",32);
		System.out.println(res1);

		int res2=userInfoRepository.updateThroughSql("update",2);
		System.out.println(res2);

	}
}
