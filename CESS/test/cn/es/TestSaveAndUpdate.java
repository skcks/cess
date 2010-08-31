package cn.es;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import cn.es.user.model.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class TestSaveAndUpdate {
	
	@Test
	@Rollback(false)
	public void testSaveStudent() {
		HibernateTemplate hibernateTemplate = new ClassPathXmlApplicationContext("beans.xml").getBean(
				"hibernateTemplate", HibernateTemplate.class);
		Student student = hibernateTemplate.get(Student.class, 2);
		student.setIntact((float) 0.4);
		hibernateTemplate.update(student);
	}
}
