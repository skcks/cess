package cn.es.evaluation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SummaryData {
	private int id; // 主键
	//private int studentId; // 外键引用学生id
	private String years; // 学年
	private float d1; // 学年品德操行基本评定积分[3评]
	private float d2; // 学年品德操行加分（最高35分）
	private float d3; // 学年品德操行扣分
	private float z1; // 公共必修课（体育课除外）、基础必修课及专业必修课、专业限选课成绩折算积分
	private float z2; // 专业自选课、公共选修课（只计综合素质学分、没有实际单科百分制成绩的公共选修除外）成绩折算积分
	private float z3; // 智育成绩加分
	private float t1; // 体育成绩积分
	private float t2; // 体育锻炼、文娱活动基本积分[3评]
	private float t3; // 文娱、体育活动加分（最高15分）

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(length = 9)
	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	public float getD1() {
		return d1;
	}

	public void setD1(float d1) {
		this.d1 = d1;
	}

	public float getD2() {
		return d2;
	}

	public void setD2(float d2) {
		this.d2 = d2;
	}

	public float getD3() {
		return d3;
	}

	public void setD3(float d3) {
		this.d3 = d3;
	}

	public float getZ1() {
		return z1;
	}

	public void setZ1(float z1) {
		this.z1 = z1;
	}

	public float getZ2() {
		return z2;
	}

	public void setZ2(float z2) {
		this.z2 = z2;
	}

	public float getZ3() {
		return z3;
	}

	public void setZ3(float z3) {
		this.z3 = z3;
	}

	public float getT1() {
		return t1;
	}

	public void setT1(float t1) {
		this.t1 = t1;
	}

	public float getT2() {
		return t2;
	}

	public void setT2(float t2) {
		this.t2 = t2;
	}

	public float getT3() {
		return t3;
	}

	public void setT3(float t3) {
		this.t3 = t3;
	}
}
