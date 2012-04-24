package springframework.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springframework.dao.EmpDao;
import springframework.vo.EmpVo;

@Service
public class EmpService {
	
	@Autowired
	EmpDao empDao;

	public List<EmpVo> getList(EmpVo empVo){
		return empDao.getList(empVo);
	}
}
