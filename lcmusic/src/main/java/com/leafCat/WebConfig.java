package com.leafCat;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Configuration
@MapperScan(value={"com.**.mapper"})
public class WebConfig extends WebMvcConfigurerAdapter{
	
	
	/*
	 * mybatis mapper 설정
	 *  
	 * */
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		Resource[] arrResource = new PathMatchingResourcePatternResolver()
				.getResources("classpath:mapper/**/*Mapper.xml");
		sqlSessionFactoryBean.setMapperLocations(arrResource);
		sqlSessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean
	public DataSourceTransactionManager transactionManager(DataSource dataSource) {
	    DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);
	    return dataSourceTransactionManager;
	}
	
	@Bean
	MappingJackson2JsonView jsonView(){
		MappingJackson2JsonView jv = new MappingJackson2JsonView();
		jv.setContentType("application/json;charset=UTF-8");
		return new MappingJackson2JsonView();
	}
	

}
