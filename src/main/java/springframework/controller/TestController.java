package springframework.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import springframework.exception.CommonException;

@Controller
public class TestController {

	@Value("#{dbProp['jdbc.driver']}")
	private String driverClassName;
	
	@RequestMapping("/index")
	public ModelAndView index(){
		
		String sampleMessage = "this url is Root";
		ModelAndView mv = new ModelAndView();
		mv.addObject("sampleMessage", sampleMessage);
		return mv;
	}
	
	@RequestMapping("/test")
	public ModelAndView test(HttpServletRequest request){
		
		String sampleMessage = "DefaultAnnotationHandlerMapping 이용";
		ModelAndView mv = new ModelAndView();
		mv.addObject("sampleMessage", sampleMessage);
		mv.addObject("propValue", driverClassName);
		
		Device currentDevice = DeviceUtils.getCurrentDevice(request);
		mv.addObject("isMobile", currentDevice.isMobile());
		
		if(true){
			try {
				throw new CommonException();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return mv;
		
	}
}
