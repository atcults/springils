package org.sanelib.ils.common.properties;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
public class AppProperties {

    private static final Logger LOG = LoggerFactory.getLogger(AppProperties.class);

	private String name;
	private String version;
	private String releaseDate;
	private String locale;
	private String messageBundle;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getMessageBundle() {
		return messageBundle;
	}

	public void setMessageBundle(String messageBundle) {
		this.messageBundle = messageBundle;
	}

	@Override
	public String toString() {
		return "AppProperties{" +
				"name='" + name + '\'' +
				", version='" + version + '\'' +
				", releaseDate='" + releaseDate + '\'' +
				", locale='" + locale + '\'' +
				", messageBundle='" + messageBundle + '\'' +
				'}';
	}

	@PostConstruct
	public void logProperties() {
		LOG.info(this.toString());
	}
}
