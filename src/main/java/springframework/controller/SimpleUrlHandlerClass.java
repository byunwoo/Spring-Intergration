package springframework.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@Controller
public class SimpleUrlHandlerClass extends MultiActionController {

	public ModelAndView test(HttpServletRequest request, HttpServletResponse response){
		
		String sampleMessage = "SimpleUrlHandlerClass~";
		ModelAndView mv = new ModelAndView();
		mv.addObject("sampleMessage", sampleMessage);
		return mv;
	}
}
