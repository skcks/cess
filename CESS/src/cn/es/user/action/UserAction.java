package cn.es.user.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

@Component("u")
@Scope("prototype")
public class UserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String username;

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	@Override
	public String execute() throws Exception {
		
		return SUCCESS;
	}

	
}
