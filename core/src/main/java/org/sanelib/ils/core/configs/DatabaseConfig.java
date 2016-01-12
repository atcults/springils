package org.sanelib.ils.core.configs;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

/**
 * Contains database configurations.
 */
@Configuration
public class DatabaseConfig {

	// ------------------------
	// PUBLIC METHODS
	// ------------------------

	/**
	 * DataSource definition for database connection. Settings are read from
	 * the application.properties file (using the env object).
	 */

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		System.out.println(env);
		dataSource.setDriverClassName(env.getProperty("db.driver"));
		dataSource.setUrl(env.getProperty("db.url"));
		dataSource.setUsername(env.getProperty("db.username"));
		dataSource.setPassword(env.getProperty("db.password"));

		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setPackagesToScan(env.getProperty("entitymanager.packagesToScan"));

		// Hibernate properties
		Properties additionalProperties = new Properties();
		additionalProperties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		additionalProperties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		additionalProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));

		sessionFactoryBean.setHibernateProperties(additionalProperties);
		return sessionFactoryBean;
	}

	// ------------------------
	// PRIVATE FIELDS
	// ------------------------

   /* @Bean
    ProcessEngineConfiguration getActivitiProcessEngineConf(){
        ProcessEngineConfiguration

    }*/
	@Autowired
	private Environment env;

} // class DatabaseConfig
