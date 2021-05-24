package spring5_webmvc_mybatis_study.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
public class ContextDataSource {  //트랜잭션 방법은 총 2개 있는데 우리는 애노테이션 사용하는 방법을 쓸것이다
	
	@Bean(destroyMethod = "close")
    public DataSource dataSource() {
       HikariConfig hikariConfig = new HikariConfig();
       hikariConfig.setDriverClassName("com.mysql.jdbc.Driver");
       hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/spring5?useSSL=false");
       hikariConfig.setUsername("user_spring5");
       hikariConfig.setPassword("rootroot");

       hikariConfig.setMaximumPoolSize(5);
       hikariConfig.setPoolName("springHikariCP");

       hikariConfig.addDataSourceProperty("dataSource.cachePrepStmts", "true");
       hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSize", "250");
       hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSqlLimit", "2048");
       hikariConfig.addDataSourceProperty("dataSource.useServerPrepStmts", "true");

       HikariDataSource dataSource = new HikariDataSource(hikariConfig);

       return dataSource;

    }
	//트랜잭션 관련
	@Bean
	public PlatformTransactionManager transactionManager() {  //여기의 데이터소스로 트랜잭션 관리할거다
	return new DataSourceTransactionManager(dataSource());
	}


}