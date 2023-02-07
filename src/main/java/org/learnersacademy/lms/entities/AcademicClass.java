package org.learnersacademy.lms.entities;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class AcademicClass {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cId;
	@Column(nullable = false,unique = true)
	private String name;	
	
	@ManyToMany(mappedBy = "classes",fetch = FetchType.EAGER)
	private Set<Subject> subjects=new HashSet<>();
	
	@OneToMany(mappedBy = "academicClass",fetch = FetchType.EAGER)
	//@JoinColumn(name="cId")
	private Set<Student> students=new HashSet<>();
	
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public Set<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(Set<Subject> subject) {
		this.subjects = subject;
	}
	
	// //helper classes \\
	
	public void addSubject(Subject subject)
	{
	
		this.subjects.add(subject);
		//subject.getClasses().add(this);
	}
	public void addStudent(Student student)
	{
		
		student.setAcademicClass(this);
		students.add(student);
		//student.addAcademicClassToStudent(this);
		
	}


}
