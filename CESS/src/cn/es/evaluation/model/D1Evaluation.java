package cn.es.evaluation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class D1Evaluation {
	private int id; // 主键
	private float politicalBeliefs; // 政治信仰
	private float politicalStudy; // 政治学习
	private float health; // 身心健康
	private float socialPractice; // 社会实践
	private float socialWork; // 社会工作
	private float abideLaw; // 遵纪守法
	private float studyAttitude; // 学习态度
	private float polite; // 文明礼貌
	private float keepMorality; // 维护社会公德
	private float lifestyleHealthHabit; // 生活作风卫生习惯
	private float thrift; // 节约
	private String source; // 评价来源：stu-学生自评，evgroup-测评小组，inst-辅导员
	private int sourceId; // 来源Id
	// private int studentId; // 外键引用学生id
	private String schoolYear; // 学年
    private boolean isSubmit;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getPoliticalBeliefs() {
		return politicalBeliefs;
	}

	public void setPoliticalBeliefs(float politicalBeliefs) {
		this.politicalBeliefs = politicalBeliefs;
	}

	public float getPoliticalStudy() {
		return politicalStudy;
	}

	public void setPoliticalStudy(float politicalStudy) {
		this.politicalStudy = politicalStudy;
	}

	public float getHealth() {
		return health;
	}

	public void setHealth(float health) {
		this.health = health;
	}

	public float getSocialPractice() {
		return socialPractice;
	}

	public void setSocialPractice(float socialPractice) {
		this.socialPractice = socialPractice;
	}

	public float getSocialWork() {
		return socialWork;
	}

	public void setSocialWork(float socialWork) {
		this.socialWork = socialWork;
	}

	public float getAbideLaw() {
		return abideLaw;
	}

	public void setAbideLaw(float abideLaw) {
		this.abideLaw = abideLaw;
	}

	public float getStudyAttitude() {
		return studyAttitude;
	}

	public void setStudyAttitude(float studyAttitude) {
		this.studyAttitude = studyAttitude;
	}

	public float getPolite() {
		return polite;
	}

	public void setPolite(float polite) {
		this.polite = polite;
	}

	public float getKeepMorality() {
		return keepMorality;
	}

	public void setKeepMorality(float keepMorality) {
		this.keepMorality = keepMorality;
	}

	@Column(precision = 4)
	public float getLifestyleHealthHabit() {
		return lifestyleHealthHabit;
	}

	public void setLifestyleHealthHabit(float lifestyleHealthHabit) {
		this.lifestyleHealthHabit = lifestyleHealthHabit;
	}

	@Column(precision = 4)
	public float getThrift() {
		return thrift;
	}

	public void setThrift(float thrift) {
		this.thrift = thrift;
	}

	@Column(length = 4)
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

	public boolean isSubmit() {
		return isSubmit;
	}

	public void setSubmit(boolean isSubmit) {
		this.isSubmit = isSubmit;
	}
}
