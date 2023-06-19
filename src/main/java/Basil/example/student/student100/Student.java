package Basil.example.student.student100;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table
public class Student {
	@Id
	@SequenceGenerator(name="student_sequence",
	sequenceName="student_sequence",
	allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
	generator="student_Sequence")
	private Long id;
	private   String name;
	private LocalDate dob;
	private int age;
	private String email;
	
	
	public Student() {
		super();
	}


	public Student(Long id, 
			String name, 
			LocalDate dob, 
			int age,
			String email) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.age = age;
		this.email=email;
	}


	public Student(String name, LocalDate dob, int age ,String email) {
		super();
		this.name = name;
		this.dob = dob;
		this.age = age;
		this.email=email;
		
		
	}


	public Student(long l, String string, String string2, LocalDate of, int i) {
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public  String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + 
				", name=" + name + 
				", dob=" + dob + 
				", age=" + age + 
				", email=" + email + 
				"]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
