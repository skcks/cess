package cn.es;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.es.user.model.Student;

public class TestSaveAndUpdate {
	@Test
	public void testSaveStudent() {
		HibernateTemplate hibernateTemplate = new ClassPathXmlApplicationContext("beans.xml").getBean(
				"hibernateTemplate", HibernateTemplate.class);
		Student student = hibernateTemplate.get(Student.class, 2);
		student.setIntact((float) 0.4);
		hibernateTemplate.update(student);
	}
}
