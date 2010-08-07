package cn.es.user.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import cn.es.information.model.ClassInfo;

@Entity
public class Instructor {
	private int id;
	private String loginName;
	private String trueName;
	private String password;
	private String mobileNO;
	private String email;
	private int permlevel;
	private Set<ClassInfo> classes = new HashSet<ClassInfo>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(length = 16)
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	@Column(length = 16)
	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	@Column(length = 32)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(length = 11)
	public String getMobileNO() {
		return mobileNO;
	}

	public void setMobileNO(String mobileNO) {
		this.mobileNO = mobileNO;
	}

	@Column(length = 32)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPermlevel() {
		return permlevel;
	}

	public void setPermlevel(int permlevel) {
		this.permlevel = permlevel;
	}

	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name = "instructorId")
	public Set<ClassInfo> getClasses() {
		return classes;
	}

	public void setClasses(Set<ClassInfo> classes) {
		this.classes = classes;
	}

}
