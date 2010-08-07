package cn.es.evaluation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class T2Evaluation {
	private int id; // 主键
	private float entmMark; // 文娱活动积分
	private float phyexeMark; // 体育锻炼积分
	private String source; // 评价来源：stu-学生自评，evgroup-测评小组，inst-辅导员
	private int sourceId; // 来源Id
	// private int studentId; // 外键引用学生id
	private String schoolYear; // 学年

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getEntmMark() {
		return entmMark;
	}

	public void setEntmMark(float entmMark) {
		this.entmMark = entmMark;
	}

	public float getPhyexeMark() {
		return phyexeMark;
	}

	public void setPhyexeMark(float phyexeMark) {
		this.phyexeMark = phyexeMark;
	}

	@Column(length = 8)
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public int getSourceId() {
		return sourceId;
	}

	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}

	@Column(length = 9)
	public String getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}
}
