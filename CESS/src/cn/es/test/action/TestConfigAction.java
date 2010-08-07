package cn.es.test.action;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

@Component("testConfig")
@Scope("prototype")
public class TestConfigAction extends ActionSupport {
	private static final long serialVersionUID = -3718632050444142897L;
	private DataSource dataSource;
	private SessionFactory sf;

	@Resource
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	@Override
	public String execute() throws Exception {
		return "listtest";
	}

	@Resource
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	public SessionFactory getSf() {
		return sf;
	}

}
