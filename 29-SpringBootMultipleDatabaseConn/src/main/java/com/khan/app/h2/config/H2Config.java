package com.khan.app.h2.config;

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
		entityManagerFactoryRef = "e2",
		basePackages = {"com.khan.app.h2.repo"},
		transactionManagerRef = "tm2"
		)
public class H2Config {

	@Autowired
	private Environment env;
	
	
	@Bean("ds2")
	@Primary
	DataSource dataSource()
	{
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setUrl(env.getProperty("app.h2.url"));
		ds.setDriverClassName(env.getProperty("app.h2.driver"));
		ds.setUsername(env.getProperty("app.h2.username"));
		ds.setPassword(env.getProperty("app.h2.password"));
		return ds;
	}
	
	@Bean("e2")
	@Primary
	LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean()
	{
		LocalContainerEntityManagerFactoryBean emfb= new LocalContainerEntityManagerFactoryBean();
		emfb.setDataSource(dataSource());
		JpaVendorAdapter jpa= new HibernateJpaVendorAdapter();
		emfb.setJpaVendorAdapter(jpa);
		Map<String, String> map= new HashMap<>();
		map.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		map.put("hibernate.hbm2ddl.auto", "update");
		map.put("hibernate.show_sql", "true");
		emfb.setJpaPropertyMap(map);
		emfb.setPackagesToScan("com.khan.app.h2.entity");
		return emfb;
	}
	
	@Bean("tm2")
	@Primary
	PlatformTransactionManager transactionManager()
	{
		JpaTransactionManager jpa=	new JpaTransactionManager();
		jpa.setEntityManagerFactory(getEntityManagerFactoryBean().getObject());
		return jpa;
	}
}
