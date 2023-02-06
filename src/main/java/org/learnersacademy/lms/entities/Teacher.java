package org.learnersacademy.lms.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.type.TrueFalseType;

@Entity
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tId;
	@Column(nullable = false,unique = true)
	private String firstName;
	private String lastName;
	private String designation;
	private long contactNo;
	private String teachingSubject;
	
	@ManyToMany(mappedBy = "teachers",fetch = FetchType.EAGER)	
	private Set<Subject> subjects=new HashSet<>();
	
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	
	public long getContactNo() {
		return contactNo;
	}
	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getTeachingSubject() {
		return teachingSubject;
	}
	public void setTeachingSubject(String teachingSubject) {
		this.teachingSubject = teachingSubject;
	}
	public Set<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
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
	public void addSubject(Subject sub)
	{
		subjects.add(sub);
		sub.getTeachers().add(this);
		
	}

}
