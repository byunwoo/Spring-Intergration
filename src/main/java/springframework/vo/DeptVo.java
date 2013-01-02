package springframework.vo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="dept")
public class DeptVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4027424349016391927L;

	@Id
	@Column(name="DEPTNO")
	private Integer deptNo;
	
	@Column(name="DNAME", length=14)
	private String dname;
	
	@Column(name="LOC", length=13)
	private String loc;
	
	@OneToMany(mappedBy="dept")
	@PrimaryKeyJoinColumn 
	private List<EmpVo> emp;

	/**
	 * @return the emps
	 */
	public List<EmpVo> getEmp() {
		return emp;
	}

	/**
	 * @param emps the emps to set
	 */
	public void setEmps(List<EmpVo> emp) {
		this.emp = emp;
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
