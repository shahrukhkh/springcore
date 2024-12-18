package com.khan.app.mysql.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "e1",
		basePackages = {"com.khan.app.mysql.repo"},
		transactionManagerRef = "tm"
		)
public class MysqlConfig {

	
	@Autowired
	private Environment env;
	
	
	@Bean("ds1")
	@Primary
	DataSource dataSource()
	{
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setUrl(env.getProperty("app.mysql.url"));
		ds.setDriverClassName(env.getProperty("app.mysql.driver"));
		ds.setUsername(env.getProperty("app.mysql.username"));
		ds.setPassword(env.getProperty("app.mysql.password"));
		return ds;
	}
	
	@Bean("e1")
	@Primary
	LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean()
	{
		LocalContainerEntityManagerFactoryBean emfb= new LocalContainerEntityManagerFactoryBean();
		emfb.setDataSource(dataSource());
		JpaVendorAdapter jpa= new HibernateJpaVendorAdapter();
		emfb.setJpaVendorAdapter(jpa);
		Map<String, String> map= new HashMap<>();
		map.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		map.put("hibernate.hbm2ddl.auto", "update");
		map.put("hibernate.show_sql", "true");
		emfb.setJpaPropertyMap(map);
		emfb.setPackagesToScan("com.khan.app.mysql.entity");
		return emfb;
	}
	
	@Bean("tm")
	@Primary
	PlatformTransactionManager transactionManager()
	{
		JpaTransactionManager jpa=	new JpaTransactionManager();
		jpa.setEntityManagerFactory(getEntityManagerFactoryBean().getObject());
		return jpa;
	}
}
