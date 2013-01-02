package springframework.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springframework.vo.EmpVo;


/**
 * @author byunwoo
 * JpaDaoSupport가 spring 3.0 -> 3.1 올라오면서 deprecated되었다. 
 * 버젼업 이후의 권장코드는 아래와 같다. 
 */
@Repository
public class EmpJpaDao {

	
	@PersistenceContext
	private EntityManager em;
 
    public void setEntityManager(EntityManager em) {
		this.em = em;
    }
	
	public EmpVo getEmp(EmpVo empVo){
		return em.find(EmpVo.class, empVo.getEmpNo());
//		getJpaTemplate().find("select e.empNo from EmpVo e")
		/*이건 정말 개작살이다....
		엔티티 파일로 정의해논 vo를 실제 물리 테이블로 여기고 쿼리를 작성한다...
		정말 디비는 없다..
		
		개 작살인 개념이다.....짱 지금등에 소름이 쫙 간다...*/
	}

	
}
