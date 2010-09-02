package cn.es.information.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ScoreInfo {
	private int id;
	private float mark; // 分数
	// private int studentId; // 外键引用学生id
	private int term; // 所属学期
	private String years; // 所属学年
	private CourseInfo course;
	
	/*分数种类Z1，Z2 ，T1*/
	private String scoreType;

	// private int courseId; // 外键引用课程id

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getMark() {
		return mark;
	}

	public void setMark(float mark) {
		this.mark = mark;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	@Column(length = 9)
	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	@OneToOne
	@JoinColumn(name = "courseId")
	public CourseInfo getCourse() {
		return course;
	}

	public void setCourse(CourseInfo course) {
		this.course = course;
	}

	@Column(length = 2)
	public String getScoreType() {
		return scoreType;
	}

	public void setScoreType(String scoreType) {
		this.scoreType = scoreType;
	}

}
