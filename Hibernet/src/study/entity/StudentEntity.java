package study.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity( name="student")
public class StudentEntity {
	@Id
	@Column(name="roll_no")
	private int id;
	
	@Column(name="student_name")
	private String name;
	
	public int getId() {
		System.out.println("getid");
		return id;
	}

	public void setId(int id) {
		System.out.println("setid");
		this.id = id;
	}

	public String getName() {
		System.out.println("getName");
		return name;
	}

	public void setName(String name) {
		System.out.println("setName");
		this.name = name;
	}
	
	public StudentEntity() {
		// TODO Auto-generated constructor stub
		System.out.println("StudentEntity()");
	}

	public StudentEntity(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	
	
}
