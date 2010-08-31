package cn.es.evaluation.service;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;


import cn.es.evaluation.model.D1Evaluation;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class D1EvaluationManagerTest {

	private static D1EvaluationManager d1EvlMgr = null;
	private static float BASIC_SCORE = 4.5f;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		d1EvlMgr = new ClassPathXmlApplicationContext("beans.xml").getBean("d1EvaluationManager",
				D1EvaluationManager.class);
		BASIC_SCORE+=Math.random();
		System.out.println("BASIC_SCORE is "+BASIC_SCORE);
	}

	@Test
	@Rollback(false)
	public void testDoSelfEvaluation() {

		D1Evaluation d1 = initialD1Entity();

		d1EvlMgr.doSelfEvaluation(d1);

		Assert.assertNotNull("ID为空", d1.getId());

	}

	private D1Evaluation initialD1Entity() {
		D1Evaluation d1 = new D1Evaluation();
		d1.setAbideLaw(BASIC_SCORE);
		d1.setHealth(BASIC_SCORE);
		d1.setKeepMorality(BASIC_SCORE);
		d1.setLifestyleHealthHabit(BASIC_SCORE);
		d1.setPolite(BASIC_SCORE);
		d1.setPoliticalBeliefs(BASIC_SCORE);
		d1.setPoliticalStudy(BASIC_SCORE);
		d1.setSchoolYear("2010-2011");
		d1.setSocialPractice(BASIC_SCORE);
		d1.setSocialWork(BASIC_SCORE);
		d1.setSource("stu");
		d1.setSourceId(1);
		d1.setStudyAttitude(BASIC_SCORE);
		d1.setSubmit(false);
		d1.setThrift(BASIC_SCORE);
		return d1;
	}

	@Test
	public void testDoEvgpEvaluation() {
		D1Evaluation d1 = initialD1Entity();

		d1EvlMgr.doEvgpEvaluation(d1);

		Assert.assertNotNull("ID为空", d1.getId());
	}

	@Test
	public void testDoInstEvaluation() {
		D1Evaluation d1 = initialD1Entity();

		d1EvlMgr.doInstEvaluation(d1);

		Assert.assertNotNull("ID为空", d1.getId());
	}

	@Test
	public void testSubmitData() {
		D1Evaluation d1 = initialD1Entity();

		d1EvlMgr.doSelfEvaluation(d1);

		Assert.assertNotNull("ID为空,添加数据失败", d1.getId());
		
		boolean submitResult = d1EvlMgr.submitData(d1.getId());
		
		Assert.assertTrue("确定D1分数失败", submitResult);
		
		System.out.println(submitResult);
	}

	@Test
	public void testCancelSubmit() {
		fail("Not yet implemented");
	}

}
