package cn.es.evaluation.service;



import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import cn.es.evaluation.model.D1Evaluation;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
@Transactional
public class D1EvaluationManagerTest {

	private D1EvaluationManager d1EvalMgr = null;
	private static float BASIC_SCORE = 4.5f;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		BASIC_SCORE += Math.random();
		System.out.println("BASIC_SCORE is " + BASIC_SCORE);
	}

	@Test
	public void testDoSelfEvaluation() {

		D1Evaluation d1 = initialD1Entity();

		d1EvalMgr.doSelfEvaluation(d1);

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

		d1EvalMgr.doEvgpEvaluation(d1);

		Assert.assertNotNull("ID为空", d1.getId());
	}

	@Test
	public void testDoInstEvaluation() {
		D1Evaluation d1 = initialD1Entity();

		d1EvalMgr.doInstEvaluation(d1);

		Assert.assertNotNull("ID为空", d1.getId());
	}

	@Test
	public void testSubmitData() {
		/*
		 * D1Evaluation d1 = initialD1Entity();
		 * 
		 * d1EvlMgr.doSelfEvaluation(d1);
		 * 
		 * Assert.assertNotNull("ID为空,添加数据失败", d1.getId());
		 */
		boolean submitResult = d1EvalMgr.submitData(5);

		Assert.assertTrue("确定D1分数失败", submitResult);

		System.out.println(submitResult);
	}

	@Test
	public void testCancelSubmit() {
		// fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		d1EvalMgr.removeD1(2);
	}

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		D1EvaluationManager d1EvaluationManager=ctx.getBean("d1EvaluationManager",D1EvaluationManager.class);
		d1EvaluationManager.submitData(2);
	}

	public D1EvaluationManager getD1EvlMgr() {
		return d1EvalMgr;
	}

	@Resource
	public void setD1EvlMgr(D1EvaluationManager d1EvaluationManager) {
		this.d1EvalMgr = d1EvaluationManager;
	}
	
	
}
