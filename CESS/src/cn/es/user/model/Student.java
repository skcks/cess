package cn.es.user.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import cn.es.information.model.ClassInfo;
import cn.es.evaluation.model.D1Evaluation;
import cn.es.scorehandle.model.ExtraScore;
import cn.es.evaluation.model.T2Evaluation;
import cn.es.information.model.ScoreInfo;
import cn.es.evaluation.model.SummaryData;

@Entity
public class Student {
	private int id;
	private String idNum;
	private String name;
	private String password;
	private String mobileNo;
	private String email;
	private float intact;
	private int permlevel;
	private ClassInfo classInfo;

	private Set<SummaryData> sumData = new HashSet<SummaryData>();
	private Set<D1Evaluation> d1Evaluations = new HashSet<D1Evaluation>();
	private Set<T2Evaluation> t2Evaluations = new HashSet<T2Evaluation>();
	private Set<ScoreInfo> scores = new HashSet<ScoreInfo>();
	private Set<ExtraScore> extraScores = new HashSet<ExtraScore>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(length = 16)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length = 32)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(length = 11)
	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Column(length = 32)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getIntact() {
		return intact;
	}

	public void setIntact(float intact) {
		this.intact = intact;
	}

	public int getPermlevel() {
		return permlevel;
	}

	public void setPermlevel(int permlevel) {
		this.permlevel = permlevel;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "classId")
	public ClassInfo getClassInfo() {
		return classInfo;
	}

	public void setClassInfo(ClassInfo classInfo) {
		this.classInfo = classInfo;
	}

	@OneToMany
	@JoinColumn(name = "StudentId")
	public Set<SummaryData> getSumData() {
		return sumData;
	}

	public void setSumData(Set<SummaryData> sumData) {
		this.sumData = sumData;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "studentId")
	public Set<D1Evaluation> getD1Evaluations() {
		return d1Evaluations;
	}
	
	public void setD1Evaluations(Set<D1Evaluation> d1Evaluations) {
		this.d1Evaluations = d1Evaluations;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "studentId")
	public Set<T2Evaluation> getT2Evaluations() {
		return t2Evaluations;
	}

	public void setT2Evaluations(Set<T2Evaluation> t2Evaluations) {
		this.t2Evaluations = t2Evaluations;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "studentId")
	public Set<ScoreInfo> getScores() {
		return scores;
	}

	public void setScores(Set<ScoreInfo> scores) {
		this.scores = scores;
	}

	@ManyToMany(mappedBy = "students")
	public Set<ExtraScore> getExtraScores() {
		return extraScores;
	}

	public void setExtraScores(Set<ExtraScore> extraScores) {
		this.extraScores = extraScores;
	}

	@Column(length = 10)
	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}


}
