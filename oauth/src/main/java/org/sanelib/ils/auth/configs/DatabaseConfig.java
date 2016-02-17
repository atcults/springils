package org.sanelib.ils.auth.configs;

import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;


@Configuration
@MapperScan("org.sanelib.ils.oauth.dao")
public class DatabaseConfig {

	@Autowired
	Environment env;
	
	@Bean
    public DataSource getDataSource() {
       BasicDataSource dataSource = new BasicDataSource();
       dataSource.setDriverClassName(env.getProperty("oauth.db.driver"));
       dataSource.setUrl(env.getProperty("oauth.db.url"));
       dataSource.setUsername(env.getProperty("oauth.db.username"));
       dataSource.setPassword(env.getProperty("oauth.db.password"));
       return dataSource;
   }
   @Bean
   public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(getDataSource());
	}
   @Bean
   public SqlSessionFactory sqlSessionFactory() throws Exception {
      SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
      sessionFactory.setDataSource(getDataSource());
      return sessionFactory.getObject();
   }
}
