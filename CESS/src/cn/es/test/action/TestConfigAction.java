package cn.es.test.action;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.es.evaluation.service.D1EvaluationManager;

import com.opensymphony.xwork2.ActionSupport;

@Component("testConfig")
@Scope("prototype")
public class TestConfigAction extends ActionSupport {
	private static final long serialVersionUID = -3718632050444142897L;
	private DataSource dataSource;

	private SessionFactory sf;
	private D1EvaluationManager d1mgr;

	@Resource
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	@Override
	public String execute() throws Exception {
		d1mgr.submitData(5);
		System.out.println("run submit!");
		return "listtest";
	}

	@Resource
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	public SessionFactory getSf() {
		return sf;
	}

	public D1EvaluationManager getD1mgr() {
		return d1mgr;
	}

	@Resource
	public void setD1mgr(D1EvaluationManager d1mgr) {
		this.d1mgr = d1mgr;
	}

}
