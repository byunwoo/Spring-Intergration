package springframework.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import springframework.vo.EmpVo;

@Repository
public class EmpDao extends SqlSessionDaoSupport {

	public List<EmpVo> getList(EmpVo empVo){
		return getSqlSession().selectList("emp.getList", empVo);
	}
}
