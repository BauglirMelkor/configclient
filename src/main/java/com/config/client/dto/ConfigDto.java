package com.config.client.dto;

import org.springframework.data.annotation.Id;

public class ConfigDto {
	

	private String applicationName;

	private String siteName;

	private Boolean basketEnabled;

	private Integer maxItemCount;
	
	private String error;

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

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
