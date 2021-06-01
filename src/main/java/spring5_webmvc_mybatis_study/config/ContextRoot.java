package spring5_webmvc_mybatis_study.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ContextDataSource.class, ContextSqlSession.class}) //여기에 있는 설정파일(Bean) 가져온다
@ComponentScan(basePackages = {
		"spring5_webmvc_mybatis_study.service"
		,"spring5_webmvc_mybatis_study.controller"
		,"spring5_webmvc_mybatis_study.mapper"
		,"spring5_webmvc_mybatis_study.common"
		//,"spring5_webmvc_mybatis_study.exception"
		})
public class ContextRoot {

}