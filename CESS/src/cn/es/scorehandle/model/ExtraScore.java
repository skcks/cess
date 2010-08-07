package cn.es.scorehandle.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import cn.es.user.model.Student;

@Entity
public class ExtraScore {
	private int id; // 主键
	private String description; // 描述
	private String source; // 添加来源
	private float mark; // 分数
	private String kind; // 种类
	private int isVerify; // 是否审核
	private String schoolYear;
	private Date addTime;
	private Set<Student> students = new HashSet<Student>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(length = 140)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(length = 64)
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public float getMark() {
		return mark;
	}

	public void setMark(float mark) {
		this.mark = mark;
	}

	@Column(length = 16)
	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	@Column(length = 1)
	public int getIsVerify() {
		return isVerify;
	}

	public void setIsVerify(int isVerify) {
		this.isVerify = isVerify;
	}

	@ManyToMany
	@JoinTable(name = "extScoreMember", 
		 joinColumns = { @JoinColumn(name = "extraScoreId") },
		 inverseJoinColumns = { @JoinColumn(name = "studentId") })
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
    @Column(length=9)
	public String getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}
    @Temporal(TemporalType.TIMESTAMP)
	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

}
