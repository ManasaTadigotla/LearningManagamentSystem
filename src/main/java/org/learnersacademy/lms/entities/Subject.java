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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.UniqueConstraint;


@Entity
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sId;
	@Column(nullable = false)	
	private String name;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="Teachers_Subjects",joinColumns = @JoinColumn(name="subject_sId"),inverseJoinColumns = @JoinColumn(name="teacher_tId"))
	Set<Teacher> teachers=new HashSet<>();
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="Class_Subjects",joinColumns = @JoinColumn(name="subject_sId"),inverseJoinColumns =  @JoinColumn(name="academicclass_cId"))
	  

	private Set<AcademicClass> classes=new HashSet<>();	
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public Set<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
	//helper methods
	public void addSubject(Subject sub)
	{
	}
	public void removeSubject(Subject sub)
	{
	}
	public Set<AcademicClass> getClasses() {
		return classes;
	}
	public void setClasses(Set<AcademicClass> classes) {
		this.classes = classes;
	}
	public void addAcademicClass(AcademicClass cls)
	{
		classes.add(cls);
		cls.getSubjects().add(this);
	}
	public void addTeacher(Teacher teach)
	{	teachers.add(teach);
		teach.getSubjects().add(this);	
		//teacher.addSubject(this);
	}
}
