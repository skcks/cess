package cn.es.scorehandle.dao.impl;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import cn.es.dao.DaoSupport;

import cn.es.scorehandle.dao.D2EvlDao;
import cn.es.scorehandle.model.ExtraScore;
import cn.es.user.model.Student;

@Component
public class D2EvlDaoMysql extends DaoSupport<ExtraScore> implements D2EvlDao {
	public D2EvlDaoMysql() {
		super();
	}

	public List<ExtraScore>  getD2BySchoolYear(int stuId,String shcoolYear){
		
		return null;
	}
	
	public Set<ExtraScore> getD2ByStuId(int stuId) {
		Student student = this.getHibernateTemplate().get(Student.class, stuId);
		return student.getExtraScores();
	}
}
