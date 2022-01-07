package com.mishra.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;


			//creating configruation file it just our Dispatcher-Servlet class
			// same as we created dispatcher-servlet.xml file
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.mishra")
public class DispatcherConfig {

	//Here we are creating view Resolver
	//just like in dispatcher Servlet but here we created class our self
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver= new InternalResourceViewResolver();
		resolver.setSuffix(".jsp");
		resolver.setPrefix("/WEB-INF/views/");
		return resolver;
	}
	
	
	//Now creating data source object
	//we are using c3p0 Connection pooling stategy in place of jdbc
	@Bean
	public ComboPooledDataSource dataSource() {
		ComboPooledDataSource source = new ComboPooledDataSource();
		try {
			source.setDriverClass("com.mysql.cj.jdbc.Driver");
			source .setJdbcUrl("jdbc:mysql://localhost:3306/SpringDemo");
			source.setUser("root");
			source.setPassword("Password123#@!");
		} catch (PropertyVetoException exception) {
			System.out.println("DataBase not Connected : "+exception);
		}
		return source;
	}
	
	//now we are creating Session Factory instance and providing them dataSource
	//instance
	@Bean
	public LocalSessionFactoryBean factoryBean() {
		LocalSessionFactoryBean sessFactoryBean = new LocalSessionFactoryBean();
		sessFactoryBean.setDataSource(dataSource());
		sessFactoryBean.setPackagesToScan("com.mishra.entity");
		Properties hibernateProperties= new Properties();
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		
		sessFactoryBean.setHibernateProperties(hibernateProperties);
		return sessFactoryBean;
	}
	
}
