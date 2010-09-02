package cn.es.scorehandle.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import cn.es.dao.DaoSupport;

import cn.es.scorehandle.dao.ExtraScoreDao;
import cn.es.scorehandle.model.ExtraScore;
import cn.es.user.model.Student;

@Component
public class ExtraScoreDaoMysql extends DaoSupport<ExtraScore> implements ExtraScoreDao {

	public List<ExtraScore> getExtraScoreBySchoolYear(int stuId, String shcoolYear) {
		List<ExtraScore> extraScores = this.getExtraScoreByStuId(stuId);
		if (null != extraScores)
			for (ExtraScore e : extraScores) {
				if (e.getSchoolYear().endsWith(shcoolYear))
					extraScores.remove(e);
			}

		return extraScores;
	}

	public List<ExtraScore> getExtraScoreByStuId(int stuId) {
		List<ExtraScore> extraScoreList = new ArrayList<ExtraScore>();
		Student student = hibernateTemplate.get(Student.class, stuId);
		if (null != student)
			for (ExtraScore e : student.getExtraScores()) {
				extraScoreList.add(e);
			}
		return extraScoreList;
	}

	public int deleteExtraScore(Serializable extraScoreId) {
		return this.delete(extraScoreId);
	}

	public int deleteExtraScoreMember(int extraScoreId, Integer... stuId) {
		int count = 0;
		ExtraScore extraScore = this.get(extraScoreId);
		if (null != extraScore) {
			Set<Student> menberSet = extraScore.getStudents();
			if (null != menberSet) {

				for (Student s : menberSet) {
					for (int id : stuId) {
						if (id == s.getId()) {
							menberSet.remove(s);
						}
					}
					count++;
				}
				extraScore.setStudents(menberSet);
			}
			this.update(extraScore);
		}
		return count;
	}

	public int saveExtraScores(List<ExtraScore> extraScores) {
		return this.saveOrUpdate(extraScores);
	}

	public List<Student> getExtraScoreMember(Serializable extraScoreId) {
		ArrayList<Student> member = new ArrayList<Student>();
		member.addAll(hibernateTemplate.get(ExtraScore.class, extraScoreId).getStudents());
		return member;
	}

}
