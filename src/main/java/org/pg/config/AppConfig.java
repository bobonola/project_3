package org.pg.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer
{
	@Override
	public void addCorsMappings( CorsRegistry registry )
	{
		CorsRegistration temp = registry.addMapping( "/**" );
		temp.allowedOrigins( "http://localhost:8081" );
	}

	@Bean
	public SqlSessionFactory sqlSessionFactoryGenerator( DataSource ds ) throws Exception
	{
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource( ds );

		PathMatchingResourcePatternResolver temp = new PathMatchingResourcePatternResolver();
		Resource[] res = temp.getResources( "classpath:/mapper/**/*.xml" );

		sessionFactory.setMapperLocations( res );

		SqlSessionFactory result = sessionFactory.getObject();
		return result;
	}

	@Bean
	public SqlSessionTemplate sqlSession( SqlSessionFactory sqlSessionFactory )
	{
		System.out.println( "sqlSessionFactory: " + sqlSessionFactory );
		SqlSessionTemplate result = new SqlSessionTemplate( sqlSessionFactory );

		return result;
	}
	

}
