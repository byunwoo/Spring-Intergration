package springframework.social;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;

@Configuration
public class SocialConfig {
	
//	스프링으로 개발한 POJO를 앞으로 다른 환경에서도 사용할 가능성이 있다면 @Inject와 DIJ에서 정의한 애노테이션을 사용하는 게 좋다. 
//	스프링만 사용할 코드라면 어느 것을 선택해도 좋은데, 대신 한 가지 종류만 선택해서 일관되게 사용하자.
	@Inject
	private org.springframework.core.env.Environment environment;
	
	@Bean
	public ConnectionFactoryLocator connectionFactoryLocator() {
	    ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
	    
//	    facebook ConnectionFactory 등록
//	    registry.addConnectionFactory(new FacebookConnectionFactory(
//    	    environment.getProperty("facebook.clientId")
//    	    , environment.getProperty("facebook.clientSecret")
//	    ));
	    
//	    twitter ConnectionFactory 등록
//	    registry.addConnectionFactory(new TwitterConnectionFactory(
//    	    environment.getProperty("twitter.consumerKey")
//    	    , environment.getProperty("twitter.consumerSecret")
//	    ));	    
	    return registry;
	}
	
	@Inject
	@Qualifier(value="dataSourceByUtil-properties")
	private DataSource dataSource;
//	위의 선언은 아래와 같이 할 수도 있다.
//	물론 변수명에 하이픈(-)은 안되니 빈 선언시에도 생각해서 빈을 선언해야겠지
//	@Resource
//	private DataSource dataSourceByUtil-properties;
	
	@Bean
	@Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)
	public ConnectionRepository connectionRepository(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            throw new IllegalStateException("Unable to get a ConnectionRepository: no user signed in");
        }
        return usersConnectionRepository().createConnectionRepository(authentication.getName());
	}
	
	@Inject
    private TextEncryptor textEncryptor;
	
	@Bean
    public UsersConnectionRepository usersConnectionRepository() {
        return new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator(), textEncryptor);
    }
	
	@Bean
    public ConnectController connectController() {
        ConnectController controller = new ConnectController(connectionFactoryLocator(), connectionRepository());
        controller.setApplicationUrl(environment.getProperty("application.url"));
        return controller;
    }
}
