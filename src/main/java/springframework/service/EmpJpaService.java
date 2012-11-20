package springframework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springframework.dao.EmpJpaDao;
import springframework.vo.EmpVo;

@Service
public class EmpJpaService {
	
	@Autowired
	EmpJpaDao empJpaDao;

	public EmpVo getEmp(EmpVo empVo){
//		return empJpaDao.getEmp(empVo);
		return empJpaDao.getEmp(empVo);
	}
}
