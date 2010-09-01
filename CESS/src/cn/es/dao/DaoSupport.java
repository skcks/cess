package cn.es.dao;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import cn.es.util.GenricsUtil;

@Component
public abstract class DaoSupport<T> implements BasicDao<T> {
	protected HibernateTemplate hibernateTemplate = null;
	protected SessionFactory sessionFactory = null;

	@SuppressWarnings("unchecked")
	protected Class<T> entityClazz = GenricsUtil.getSuperClassGenricType(this.getClass(), 0);

	public int delete(Serializable... ids) {
		StringBuilder sb = new StringBuilder("delete from ");
		if (null == ids || 0 == ids.length) {
			return 0;
		}
		
		sb.append(GenricsUtil.getEntityName(entityClazz));
		sb.append(" t where t.");
		sb.append(GenricsUtil.getIdName(entityClazz)).append(" in(");
		for (int i = 0; i < ids.length; i++) {
			sb.append("?,");
		}
		sb.setCharAt(sb.length()-1, ')');
		//buildINParams(sb, ids);

		System.out.println("query string is " + sb.toString());

		return hibernateTemplate.bulkUpdate(sb.toString(),ids);
	}

	public T get(Serializable id) {
		return hibernateTemplate.get(entityClazz, id);
	}

	public QueryResult<T> getAllData() {
		return getPageData(-1, -1, null, null, null);
	}

	public QueryResult<T> getListData(int startIndex, int maxCount) {
		return getPageData(startIndex, maxCount, null, null, null);
	}

	public QueryResult<T> getOrderListData(int startIndex, int maxCount, LinkedHashMap<String, String> orderFeilds) {
		return getPageData(startIndex, maxCount, null, null, orderFeilds);
	}

	@SuppressWarnings("unchecked")
	public QueryResult<T> getPageData(int startIndex, int maxCount, String whereQL, Object[] params,
			LinkedHashMap<String, String> orderFeilds) {
		StringBuilder sb = new StringBuilder("from ");
		sb.append(GenricsUtil.getEntityName(entityClazz)).append(" t");

		if (null != whereQL && !"".endsWith(whereQL.trim())) {
			sb.append("where ").append(whereQL);
		}

		sb.append(formatOrderByMapToString(orderFeilds));
		System.out.println("query string is:" + sb.toString());

		Query query = sessionFactory.getCurrentSession().createQuery(sb.toString());

		fiilQueryParams(query, params);

		if (startIndex > 0 && maxCount > 0) {
			query.setFirstResult(startIndex);
			query.setMaxResults(maxCount);
		}

		QueryResult<T> queryResult = new QueryResult<T>();
		queryResult.setListData(query.list());
		
		sb.delete(0, sb.length());
		sb.append("select Count(*) from ");
		sb.append(GenricsUtil.getEntityName(entityClazz)).append(" t where");
		sb.append(whereQL);
		
		query=sessionFactory.getCurrentSession().createQuery(sb.toString());
		queryResult.setTotalCount((Integer)query.uniqueResult());
		
		return queryResult;
	}

	private String formatOrderByMapToString(Map<String, String> orderFeilds) {
		StringBuilder sb = new StringBuilder();
		if (null != orderFeilds && orderFeilds.size() > 0) {
			sb.append(" order by ");
			for (String key : orderFeilds.keySet()) {
				sb.append("t.").append(key).append(' ').append(orderFeilds.get(key)).append(' ');
			}
			sb.deleteCharAt(sb.length() - 1);
		}
		System.out.println("order by String is :" + sb);
		return sb.toString();
	}

	private void fiilQueryParams(Query query, Object[] params) {
		if (null != params && params.length > 0) {
			for (int i = 1; i <= params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
	}

	
	
	public int isExist(Serializable... ids) {
		StringBuilder sb = new StringBuilder("select count(*) from ");
		if (null == ids || 0 == ids.length) {
			return 0;
		}
		sb.append(entityClazz.getSimpleName());
		sb.append(" t where t.");
		sb.append(GenricsUtil.getIdName(entityClazz));
		buildINParams(sb, ids);
		System.out.println(sb);
		long retval=(Long) hibernateTemplate.find(sb.toString()).get(0);
		//System.out.println("retval="+retval);
		return (int)retval;
		
	}

	public Serializable save(T entity) {
		return hibernateTemplate.getSessionFactory().getCurrentSession().save(entity);
	}

	public void update(T entity) {
		hibernateTemplate.update(entity);
	}

	private void buildINParams(StringBuilder sb, Serializable... ids) {
		sb.append(" IN(");
		for (Serializable id : ids) {
			if (id instanceof String) {
				sb.append("`" + id + "`").append(',');
			} else {
				sb.append(id).append(',');
			}
		}
		sb.setCharAt(sb.length() - 1, ')');
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		
		this.hibernateTemplate = hibernateTemplate;
		this.sessionFactory=this.hibernateTemplate.getSessionFactory();
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public int saveOrUpdate(List<T> entitys) {
		int saveCount = 0;
		for (T entity : entitys) {
			this.hibernateTemplate.save(entity);
			saveCount++;
			if (0 == saveCount % 10) {
				sessionFactory.getCurrentSession().flush();
				sessionFactory.getCurrentSession().clear();
				saveCount = 0;
			}
		}
		return entitys.size();
	}

}
