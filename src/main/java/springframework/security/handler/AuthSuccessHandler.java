package springframework.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

/**
 * spring 3부터 security 인증 성공시 처리할 핸들러 등록/사용이 가능해졌다.
 * @author byunwoo
 *
 */
public class AuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	static final String REQUEST_PARAM_NAME = "_remember_username";

	static final String COOKIE_NAME = "saved_username";

	static final int DEFAULT_MAX_AGE = 60 * 60 * 24 * 7;

	private int maxAge = DEFAULT_MAX_AGE;

	public void setMaxAge(int maxAge) {

		this.maxAge = maxAge;

	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response,

			Authentication authentication) throws IOException, ServletException {

		String remember = request.getParameter(REQUEST_PARAM_NAME);

		if (remember != null) {

			String username = ((UserDetails) authentication.getPrincipal())
					.getUsername();

			Cookie cookie = new Cookie(COOKIE_NAME, username);

			cookie.setMaxAge(maxAge);

			response.addCookie(cookie);

		}

		else {

			Cookie cookie = new Cookie(COOKIE_NAME, "");

			cookie.setMaxAge(0);

			response.addCookie(cookie);

		}

		super.onAuthenticationSuccess(request, response, authentication);

	}

}
