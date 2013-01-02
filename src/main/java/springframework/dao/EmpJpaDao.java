package springframework.dao;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.stereotype.Repository;

import springframework.vo.EmpVo;

@Repository
public class EmpJpaDao extends JpaDaoSupport {

	@Autowired
    public void setEmf(EntityManagerFactory entityManagerFactory) {
        super.setEntityManagerFactory(entityManagerFactory);
    }
	
	public EmpVo getEmp(EmpVo empVo){
		return getJpaTemplate().find(EmpVo.class, empVo.getEmpNo());
//		getJpaTemplate().find("select e.empNo from EmpVo e")
		/*이건 정말 개작살이다....
		엔티티 파일로 정의해논 vo를 실제 물리 테이블로 여기고 쿼리를 작성한다...
		정말 디비는 없다..
		
		개 작살인 개념이다.....짱 지금등에 소름이 쫙 간다...*/
	}

	
}
