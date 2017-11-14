package com.config.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.config.client.persistence.entity.ConfigEntity;
import com.config.client.server.ConfigService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigclientApplicationTests {
	
	@Autowired
	private ConfigService configService;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void saveAndfindSuccessFully() {
		configService.save("testsite.com", true, 100, "service1");
		ConfigEntity configEntity = configService.find("service1");
		assert(configEntity.getApplicationName().equals("service1"));
		assert(configEntity.getBasketEnabled()==true);
		assert(configEntity.getMaxItemCount().intValue()==100);
		assert(configEntity.getSiteName().equals("testsite.com"));
	}

}
