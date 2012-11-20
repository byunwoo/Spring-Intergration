package test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(
	locations = 
	{
		"classpath:/spring-servlet-test.xml"
	}
//	loader=AnnotationConfigContextLoader.class 이 라인을 붙이면 해당 테스트 자바 안에 @Configuration으로 선언한 빈을 찾는다. 외부 xml에서가 아니고.
)
public class ContextTestUnit {

//	@Autowired
	@Autowired
	protected GenericApplicationContext context;
	
	@Inject
	private org.springframework.core.env.Environment environment;
	
	@Test
	public void testContextMethod (){
		//수행코드
		System.err.println("********************************************************************");
		System.err.println(environment.getActiveProfiles());
		System.err.println(environment.getProperty("jdbc.url"));
		System.err.println("********************************************************************");
	}
}
