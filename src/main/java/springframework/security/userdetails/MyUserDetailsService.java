package springframework.security.userdetails;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService {

	private Map<String, UserDetails> userMap;
	
	public MyUserDetailsService() {
		init();
	}
	
	private void init() {
		userMap = new HashMap<String, UserDetails>();
		userMap.put("byunwoo", new MyUserDetails("byunwoo", "1234", "ROLE_USER"));
		userMap.put("admin", new MyUserDetails("admin", "1234", "ROLE_ADMIN"));
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userMap.get(username);
	}
	
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
//		return userMap.get(username);
//	}

}
