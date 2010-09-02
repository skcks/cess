package cn.es.scorehandle.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.es.scorehandle.dao.ExtraScoreDao;
import cn.es.scorehandle.dao.impl.ExtraScoreDaoMysql;
import cn.es.scorehandle.model.ExtraScore;

@Service
public class ExtraScoreManage {
	private ExtraScoreDao extraScoreDao = null;

	public List<ExtraScore> queryStudentD2Score(int stuId) {
		return null;
	}

	public List<ExtraScore> addExtraScoreMember(int extraScoreId) {
		return null;
	}

	public List<ExtraScore> removeExtraScoreMember(int extraScoreId, Integer... memberIds) {
		return null;
	}

	public ExtraScoreDao getExtraScoreDao() {
		return extraScoreDao;
	}

	@Resource
	public void setExtraScoreDao(ExtraScoreDaoMysql extraScoreDaoMysql) {
		this.extraScoreDao = extraScoreDaoMysql;
	}

}
