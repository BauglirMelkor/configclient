package com.config.client.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ConfigEntity {

	@Id
	private String applicationName;

	private String siteName;

	private Boolean basketEnabled;

	private Integer maxItemCount;

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public Boolean getBasketEnabled() {
		return basketEnabled;
	}

	public void setBasketEnabled(Boolean basketEnabled) {
		this.basketEnabled = basketEnabled;
	}

	public Integer getMaxItemCount() {
		return maxItemCount;
	}

	public void setMaxItemCount(Integer maxItemCount) {
		this.maxItemCount = maxItemCount;
	}

}
