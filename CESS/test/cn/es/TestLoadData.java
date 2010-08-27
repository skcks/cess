package cn.es;

import java.util.Iterator;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import cn.es.user.model.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class TestLoadData {
	private HibernateTemplate hibernateTemplate;
    
	@Test
	@Rollback(true)
	public void testLoadStudentInfo() {

		
		Student student = (Student) hibernateTemplate.load(Student.class, 2);
		System.out.println("学生姓名：" + student.getName());
		System.out.println("专业：" + student.getClassInfo().getSpeciality());
		double myIntact=student.getIntact();
		int myId=student.getId();
		student.setIntact((float) 3.5);
		hibernateTemplate.update(student);
		System.out.println("myIntact:"+myIntact+";now is "+((Student) hibernateTemplate.load(Student.class, myId)).getIntact());
		System.out.println("-----------------------同班同学----------------------");
		for (Iterator<Student> iterator = student.getClassInfo().getStudents().iterator(); iterator.hasNext();) {
			Student classmember = iterator.next();
			System.out.println("学生名：" + classmember.getName());
			System.out.println("学号：" + classmember.getIdNum());
		}
		System.out.println("-----------------------------------------------------");

		System.out.println("-----------------------评测小组成员----------------------");
		for (Iterator<Student> iterator = student.getClassInfo().getEvalGroupMembers().iterator(); iterator.hasNext();) {
			Student member = (Student) iterator.next();
			System.out.println("成员名：" + member.getName());
		}
		System.out.println("--------------------------------------------------------");

		System.out.println("辅导员：" + student.getClassInfo().getInstructor().getTrueName());

	}

	@Resource
	public void setSf(SessionFactory sf) {
		this.hibernateTemplate = new HibernateTemplate(sf);
	}
	@Test
	@Rollback(true)
	public void testSaveStudent() {
		Student student=hibernateTemplate.get(Student.class,2);
		student.setIntact((float) 0.15);
		hibernateTemplate.update(student);
	}
}
