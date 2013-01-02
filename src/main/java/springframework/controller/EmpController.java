package springframework.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import springframework.service.EmpJpaService;
import springframework.service.EmpService;
import springframework.vo.EmpVo;

@Controller
public class EmpController {

	@Autowired
	EmpService empService;
	@Autowired
	EmpJpaService empJpaService;
	
	@RequestMapping("/empList")
	public ModelAndView list(){
		ModelAndView mv = new ModelAndView();
		
		List list = null;
		list = empService.getList(new EmpVo());
		mv.addObject("empList", list);
		
		String sampleMessage = "EMP List Return~";
		mv.addObject("sampleMessage", sampleMessage);
		
		return mv;
	}
	
	@RequestMapping(value="/getEmp/{emp_no}")
	public ModelAndView getEmp(@PathVariable int emp_no){
		ModelAndView mv = new ModelAndView();
		
		EmpVo empVo = new EmpVo();
		empVo.setEmpNo(emp_no);
		
		mv.setViewName("getEmp");
		mv.addObject("emp", empJpaService.getEmp(empVo));
		
		String sampleMessage = "EMP Return~";
		mv.addObject("sampleMessage", sampleMessage);
		
		return mv;
	}
	
//	@ResponseBody 어노테이션은 리턴 오브젝트
//	(EmpVo 또는 List<EmpVo>)를 응답 본문 내용으로 만드는 데 사용되고, 
//	이로 인해 viewResolver.xml에 등록한 MappingJacksonHttpMessageConverter 가 JSON으로 맵핑될 것이다. 
	
	@RequestMapping(method=RequestMethod.GET, value="/empJson/{id}", headers="Accept=application/json")
	public @ResponseBody EmpVo getEmp(@PathVariable Integer id) {
		EmpVo vo = new EmpVo();
		vo.setEmpNo(id);
//		EmpVo e = empJpaService.getEmp(vo);
		EmpVo e = new EmpVo();
		return e;
	}
		
//	@RequestMapping(method=RequestMethod.GET, value="/empsJson", headers="Accept=application/json")
	@RequestMapping(value="/empsJson")
	public @ResponseBody List<EmpVo> getAllEmp() {
		List<EmpVo> employees = empService.getList(new EmpVo());
		return employees;
	}
	
}
