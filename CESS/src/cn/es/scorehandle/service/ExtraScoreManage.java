package cn.es.scorehandle.service;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.es.scorehandle.dao.ExtraScoreDao;
import cn.es.scorehandle.dao.impl.ExtraScoreDaoMysql;
import cn.es.scorehandle.model.ExtraScore;
import cn.es.user.model.Student;

@Service
public class ExtraScoreManage {
	private ExtraScoreDao extraScoreDao = null;
		
	public List<ExtraScore> queryStudentDScore(int stuId) {
		return extraScoreDao.getExtraScoreByStuId(stuId);
	}
	
	public int addExtraScoreMember(int extraScoreId,List<Student> students) {
		ExtraScore extraScore =  extraScoreDao.get(extraScoreId);
		Set<Student> member = extraScore.getStudents();
		member.addAll(students);
		extraScoreDao.update(extraScore);
		return students.size();
	}

	public int removeExtraScoreMember(int extraScoreId, Integer... memberIds) {
		return extraScoreDao.deleteExtraScoreMember(extraScoreId, memberIds);
	}

	
	
	public ExtraScoreDao getExtraScoreDao() {
		return extraScoreDao;
	}

	@Resource
	public void setExtraScoreDao(ExtraScoreDaoMysql extraScoreDaoMysql) {
		this.extraScoreDao = extraScoreDaoMysql;
	}

}
