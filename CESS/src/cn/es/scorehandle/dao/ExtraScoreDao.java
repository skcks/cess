package cn.es.scorehandle.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import cn.es.dao.BasicDao;
import cn.es.scorehandle.model.ExtraScore;

public interface ExtraScoreDao extends BasicDao<ExtraScore> {
	public Set<ExtraScore> getExtraScoreByStuId(int stuId);

	public List<ExtraScore> getExtraScoreBySchoolYear(int stuId, String shcoolYear);

	public int saveExtraScore(List<ExtraScore> extraScore);

	public int deleteExtraScore(Serializable extraScoreId);

	public int deleteExtraScoreMember(int extraScoreId, Integer... stuId);
}
