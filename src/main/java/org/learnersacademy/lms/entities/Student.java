package org.learnersacademy.lms.entities;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	@Column(unique = true,nullable = false)
	private String firstName;
	private String lastName;
	private long contactNo;
	private String email;
	private String address;
	private int age;
	private String studyClass;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="cId")
	private AcademicClass academicClass;

	public int getStudentId() {
		return studentId;
	}
	

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getContactNo() {
		return contactNo;
	}


	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getStudyClass() {
		return studyClass;
	}

	public void setStudyClass(String studyClass) {
		this.studyClass = studyClass;
	}

	public AcademicClass getAcademicClass() {
		return academicClass;
	}

	public void setAcademicClass(AcademicClass academicClass) {
		this.academicClass = academicClass;
	}

////helper classes  //
	public void addAcademicClassToStudent(AcademicClass aClass)
	{
		
		//academicClass.addStudent(this);
		aClass.getStudents().add(this);
	
	}
	

}
