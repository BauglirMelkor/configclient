package com.config.client.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.config.client.persistence.entity.ConfigEntity;
import com.config.client.persistence.repository.ConfigRepository;

@Service
public class ConfigService {
	
	@Autowired
	private ConfigRepository configRepository;
	
	public ConfigEntity save(String siteName,Boolean basketEnabled,Integer maxItemCount,String applicationName) {
		
		ConfigEntity configEntity = configRepository.findOne(applicationName);
		if(configEntity==null) {
		configEntity = new ConfigEntity();
		}
		configEntity.setApplicationName(applicationName);
		configEntity.setBasketEnabled(basketEnabled);
		configEntity.setMaxItemCount(maxItemCount);
		configEntity.setSiteName(siteName);
		configRepository.save(configEntity);
		return configEntity;
	
	}
	
	public ConfigEntity find(String applicationName) {
		ConfigEntity configEntity = configRepository.findOne(applicationName);
		return configEntity;
	}

}
