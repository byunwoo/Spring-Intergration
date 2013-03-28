package springframework.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import springframework.service.EmpJpaService;
import springframework.service.EmpService;
import springframework.vo.EmpVo;

@Controller
//@RequestMapping("/Emp") 컨트롤러 대표 루트경로를 주고 싶으면 이렇게
public class EmpController {

	Logger log = LoggerFactory.getLogger(EmpController.class); 
	
	@Autowired
	EmpService empService;
	@Autowired
	EmpJpaService empJpaService;
	
	@ModelAttribute("commonStringArr")
	public String[] commmonStringArr(){
		return new String[]{"common1","common2","common3","common4","common5"};
	}
	
	@RequestMapping("/empList")
	public ModelAndView list(){
		ModelAndView mv = new ModelAndView();
		
		List list = null;
		EmpVo paramVo = new EmpVo();
		paramVo.setEmpNo(1);
		list = empService.getList(paramVo);
		mv.addObject("empList", list);
		log.info("emp list ====================== {}", list.size());
		String sampleMessage = "EMP List Return~";
		mv.addObject("sampleMessage", sampleMessage);
		
		return mv;
	}
	
	@RequestMapping(value="/getEmp/{emp_no}")
	public ModelAndView getEmp(@PathVariable int emp_no){
		ModelAndView mv = new ModelAndView();
		log.info("emp no ====================== {}", emp_no);
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
		EmpVo e = empJpaService.getEmp(vo);
		return e;
	}
		
//	@RequestMapping(method=RequestMethod.GET, value="/empsJson", headers="Accept=application/json")
	@RequestMapping(value="/empsJson")
	public @ResponseBody List<EmpVo> getAllEmp() {
		List<EmpVo> employees = empService.getList(new EmpVo());
		return employees;
	}
	
}
