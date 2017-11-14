package com.config.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.config.client.config.ClientConfig;
import com.config.client.dto.ConfigDto;
import com.config.client.persistence.entity.ConfigEntity;
import com.config.client.server.ConfigService;

@RefreshScope
@RestController
public class ClientController {

	@Autowired
	private ConfigService configService;

	@Autowired
	private ClientConfig clientConfig;

	@RequestMapping("/siteName")
	public String getSiteName() {
		return clientConfig.getSiteName();
	}

	@RequestMapping("/isBasketEnabled")
	public Boolean isBasketEnabled() {
		return clientConfig.getBasketEnabled();
	}

	@RequestMapping("/maxItemCount")
	public Integer getMaxItemCount() {
		return clientConfig.getMaxItemCount();
	}

	@RequestMapping("/save/{siteName}/{isBasketEnabled}/{maxItemCount}/{applicationName}")
	public ResponseEntity<ConfigDto> save(@PathVariable(value = "siteName", required = true) String siteName,
			@PathVariable(value = "isBasketEnabled", required = true) Boolean basketEnabled,
			@PathVariable(value = "maxItemCount", required = true) Integer maxItemCount,
			@PathVariable(value = "applicationName", required = true) String applicationName) {
		ConfigDto configDto = new ConfigDto();
		try {
			ConfigEntity configEntity = configService.save(siteName, basketEnabled, maxItemCount, applicationName);
			configDto.setApplicationName(configEntity.getApplicationName());
			configDto.setBasketEnabled(configEntity.getBasketEnabled());
			configDto.setSiteName(configEntity.getSiteName());
			configDto.setMaxItemCount(configEntity.getMaxItemCount());
			setClientConfig(configEntity);
		} catch (Exception e) {
			configDto.setError(e.getMessage());
		}
		return ResponseEntity.ok(configDto);
	}

	@RequestMapping("/find/{applicationName}")
	public ResponseEntity<ConfigDto> save(@PathVariable(value = "applicationName", required = true) String applicationName) {
		ConfigDto configDto = new ConfigDto();
		try {
			ConfigEntity configEntity = configService.find(applicationName);
			configDto.setApplicationName(configEntity.getApplicationName());
			configDto.setBasketEnabled(configEntity.getBasketEnabled());
			configDto.setSiteName(configEntity.getSiteName());
			configDto.setMaxItemCount(configEntity.getMaxItemCount());
			setClientConfig(configEntity);
		} catch (Exception e) {
			configDto.setError(e.getMessage());
		}
		return ResponseEntity.ok(configDto);
	}

	private void setClientConfig(ConfigEntity configEntity) {
		clientConfig.setBasketEnabled(configEntity.getBasketEnabled());
		clientConfig.setSiteName(configEntity.getSiteName());
		clientConfig.setMaxItemCount(configEntity.getMaxItemCount());
	}

}
