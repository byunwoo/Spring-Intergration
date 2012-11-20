package springframework.social;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;

@Configuration
public class SecurityConfig {
	
	@Configuration
    @Profile("dev")
    static class Dev {

        @Bean
        public TextEncryptor textEncryptor() {
            return Encryptors.noOpText();
        }

    }
    
    @Configuration
    @Profile("prod")
    static class Prod {

        @Bean
        public TextEncryptor textEncryptor() {
            return Encryptors.queryableText(environment.getProperty("security.encryptPassword"),
                environment.getProperty("security.encryptSalt"));
        }

        @Inject
        private Environment environment;

    }
}
