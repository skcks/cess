package cn.es.user.service;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;


import cn.es.user.model.Student;

@Service
public class StudentMgr {
	private SessionFactory sessionFactory=null;
	
	
	public int addNewStudent(Student student){
		sessionFactory.getCurrentSession().save(student);
		return student.getId();
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Resource(name="hibernateTemplate")
	public void setSessionFactory(HibernateTemplate hibernateTemplate) {
		this.sessionFactory = hibernateTemplate.getSessionFactory();
	}
}
