package springframework.vo;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name="emp")
public class EmpVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6943688991629167149L;

	@Id
	@Column(name="EMPNO")
	private Integer empNo;
	
	@Column(name="ENAME", length=10)
	private String ename;
	
	@Column(name="JOB", length=9)
	private String job;
	
	@Column(name="MGR")
	private Integer mgr;
	
	@Column(name="HIREDATE")
	@DateTimeFormat(pattern="yyyy-MM-dd") //joda-time-library 필요
	private Date hireDate;
	
	@Column(name="SAL")
	@NumberFormat(pattern="###,###")
	private Integer sal;
	
	@Column(name="COMM")
	private Integer comm;
	
	@Column(name="DEPTNO")
	private Integer deptNo;
	
	@ManyToOne(optional=true)
//	cascade=CascadeType.REFRESH
	@JoinColumn(name="DEPTNO", updatable=false, insertable=false)
//	updatable=false, insertable=false 이것을 명시해 줘야한다.
//	의미상 으로 보면 명확하다. 자식에서 부모키를 업뎃하거나 저장할수 없다는 뜻이다. 당연하다...
	private DeptVo dept;
	
	/**
	 * @return the dept
	 */
	public DeptVo getDept() {
		return dept;
	}
	/**
	 * @param dept the dept to set
	 */
	public void setDept(DeptVo dept) {
		this.dept = dept;
	}
	public Integer getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Integer getMgr() {
		return mgr;
	}
	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public Integer getSal() {
		return sal;
	}
	public void setSal(Integer sal) {
		this.sal = sal;
	}
	public Integer getComm() {
		return comm;
	}
	public void setComm(Integer comm) {
		this.comm = comm;
	}
	public Integer getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}
	
}
