package cn.es.information.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import cn.es.user.model.Instructor;
import cn.es.user.model.Student;

@Entity
public class ClassInfo{
	private int id; // 主键
	private int num; // 班级数
	private String speciality; // 专业
	private String faculty; // 院系
	//private int instructorId; // 外键引用辅导员id
	private  Instructor instructor;
	private String years; // 学习年数
	private Set<Student> students = new HashSet<Student>();
    private Set<Student> evalGroupMembers=new  HashSet<Student>();
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(length = 2)
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Column(length = 32)
	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	@Column(length = 32)
	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

/*	public int getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}*/

	@Column(length = 9)
	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	@OneToMany(mappedBy = "classInfo",cascade={CascadeType.ALL})
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public void setEvalGroupMembers(Set<Student> evalGroupMembers) {
		this.evalGroupMembers = evalGroupMembers;
	}
    @OneToMany
    @JoinTable(name="EvalGroup",
    		   joinColumns={@JoinColumn(name="classId")},
    		   inverseJoinColumns={@JoinColumn(name="studentId")}
    )
  	public Set<Student> getEvalGroupMembers() {
		return evalGroupMembers;
	}
    @ManyToOne
    @JoinColumn(name="instructorID")
	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

}
