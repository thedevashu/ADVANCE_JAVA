package study.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="emp") //create table emp
public class EmployeeEntity {
	@Id
	@Column(name="eid")
	private int empid;//create table emp(eid int primary key,
	@Column(name="ename")
	private String ename;//create table emp(eid int primary key,ename varchar,
	@Column(name="job")
	private String job;//create table emp(eid int primary key,ename varchar,job varchar)
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
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
	public EmployeeEntity(int empid, String ename, String job) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.job = job;
	}
	
	

}
