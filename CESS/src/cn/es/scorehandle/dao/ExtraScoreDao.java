package cn.es.scorehandle.dao;

import java.io.Serializable;
import java.util.List;


import cn.es.dao.BasicDao;
import cn.es.scorehandle.model.ExtraScore;
import cn.es.user.model.Student;

public interface ExtraScoreDao extends BasicDao<ExtraScore> {
	
	public List<ExtraScore> getExtraScoreByStuId(int stuId);

	public List<ExtraScore> getExtraScoreBySchoolYear(int stuId, String shcoolYear);

	public int saveExtraScores(List<ExtraScore> extraScores);

	public List<Student> getExtraScoreMember(Serializable extraScoreId);
	
	public int deleteExtraScore(Serializable extraScoreId);

	public int deleteExtraScoreMember(int extraScoreId, Integer... stuId);
}
