package springframework.controller.hybridweb;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@Controller
public class JqueryMobileController extends MultiActionController {

	public ModelAndView sample(HttpServletRequest request, HttpServletResponse response){
		
		ModelAndView mv = new ModelAndView();
		return mv;
	}
}
