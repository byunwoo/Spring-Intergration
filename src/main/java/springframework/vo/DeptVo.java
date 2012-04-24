package springframework.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="dept")
public class DeptVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4027424349016391927L;

	@Id
	@Column(name="DEPTNO", nullable=false, unique=true)
	private Integer deptNo;
	
	@Column(name="DNAME", length=14)
	private String dname;
	
	@Column(name="LOC", length=13)
	private String loc;
	
	@OneToMany(mappedBy="dept")
	private Set<EmpVo> emps;

	/**
	 * @return the emps
	 */
	public Set<EmpVo> getEmps() {
		return emps;
	}

	/**
	 * @param emps the emps to set
	 */
	public void setEmps(Set<EmpVo> emps) {
		this.emps = emps;
	}

	/**
	 * @return the deptNo
	 */
	public Integer getDeptNo() {
		return deptNo;
	}

	/**
	 * @param deptNo the deptNo to set
	 */
	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}

	/**
	 * @return the dname
	 */
	public String getDname() {
		return dname;
	}

	/**
	 * @param dname the dname to set
	 */
	public void setDname(String dname) {
		this.dname = dname;
	}

	/**
	 * @return the loc
	 */
	public String getLoc() {
		return loc;
	}

	/**
	 * @param loc the loc to set
	 */
	public void setLoc(String loc) {
		this.loc = loc;
	}

	
}
