package com.config.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfig {

	@Value("${app.config.sitename}")
	private String siteName;

	@Value("${app.config.isbasketenabled}")
	private Boolean basketEnabled;

	@Value("${app.config.maxitemcount}")
	private Integer maxItemCount;

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
