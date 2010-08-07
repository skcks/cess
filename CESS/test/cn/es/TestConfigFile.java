package cn.es;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestConfigFile {
	@Test
	public void testDataSource() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		DataSource dataSource = ctx.getBean("dataSource", DataSource.class);
		Assert.assertNotNull("不能通过spring获取dataSource", dataSource);

		Connection conn = dataSource.getConnection();
		Assert.assertNotNull("不能通过dataSource获取Connection", conn);
		System.out.println(dataSource.getClass().getName());

		ResultSet mdrs = conn.getMetaData().getCatalogs();
		System.out.println("存在下列数据库：");
		for (; mdrs.next();) {
			System.out.println(mdrs.getString(1));
		}
		mdrs.close();

		System.out.println("在数据库cess中存在下列表");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("show tables");
		for (; rs.next();) {
			System.out.println(rs.getString(1));
		}
		rs.close();
		stmt.close();
	}

	@Test
	public void testSessionFactory() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		SessionFactory sf = ctx.getBean("sf", SessionFactory.class);
		Assert.assertNotNull(sf);
		Session seesion = sf.openSession();
		System.out.println(seesion.getClass().getName());
		Assert.assertNotNull(seesion);
		seesion.close();
	}

	@Test
	public void testSchemaExport() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		SessionFactory sf = ctx.getBean("sf", SessionFactory.class);
		Assert.assertNotNull(sf);
	}
}
