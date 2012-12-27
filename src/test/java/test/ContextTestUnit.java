package test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(
	locations = 
	{
		"classpath:/spring-servlet-test.xml"
	}
//	loader=AnnotationConfigContextLoader.class 이 라인을 붙이면 해당 테스트 자바 안에 @Configuration으로 선언한 빈을 찾는다. 외부 xml에서가 아니고.
)
//@PropertySource("classpath:/properties/db.properties")
public class ContextTestUnit {

	@Autowired
	protected GenericApplicationContext context;
	
	@Inject
	private Environment environment;
	
	@Value("#{dbProp['jdbc.url']}")
	private String dbUrl;
	
	@Test
	public void testContextMethod (){
		//수행코드
		System.err.println("********************************************************************");
		System.err.println(dbUrl);
		System.err.println(environment.getActiveProfiles());
		System.err.println(environment.getProperty("jdbc.url"));
		System.err.println("********************************************************************");
	}
}
