package com.ulysses.base.dao.support;

import org.springframework.dao.support.DaoSupport;
import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.stereotype.Repository;

import com.ulysses.base.bean.PageBean;


public class BaseHibernateDao extends DaoSupport {

	private SessionFactory sessionFactory;
	private HibernateTemplate hibernateTemplate;
	private Session session;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		this.hibernateTemplate = createHibernateTemplate(sessionFactory);
	}

	public Session getSession() {
		if (this.sessionFactory == null) {
			throw new HibernateException(
					"Session Create Fail,SessionFactory is null!");
		}
		
		return this.sessionFactory.getCurrentSession();
		//openSession 始终创建新的session
//		return this.sessionFactory.openSession();
	}

	protected HibernateTemplate createHibernateTemplate(
			SessionFactory sessionFactory) {
		return new HibernateTemplate(sessionFactory);
	}

	@Override
	protected void checkDaoConfig() throws IllegalArgumentException {
		if (this.hibernateTemplate == null) {
			throw new IllegalArgumentException(
					"'sessionFactory' or 'hibernateTemplate' is required");
		}
	}

	protected final Session getSession(boolean allowCreate)
			throws DataAccessResourceFailureException, IllegalStateException {
		return (!allowCreate ? SessionFactoryUtils.getSession(
				getSessionFactory(), false) : SessionFactoryUtils.getSession(
				getSessionFactory(),

				this.hibernateTemplate.getEntityInterceptor(),
				this.hibernateTemplate.getJdbcExceptionTranslator()));
	}

	protected final DataAccessException convertHibernateAccessException(
			HibernateException ex) {
		return this.hibernateTemplate.convertHibernateAccessException(ex);
	}

	protected final void releaseSession(Session session) {
		SessionFactoryUtils.releaseSession(session, getSessionFactory());
		if (null != session)
			session = null;
	}

	public final void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public final HibernateTemplate getHibernateTemplate() {
		return this.hibernateTemplate;
	}

	/**
	 * 设置分页信息
	 * @param queryObject
	 * @param page 
	 */
	protected void setPage(Query queryObject, PageBean page) {
		queryObject.setFirstResult(page.getPageSize()*page.getPageNumber());
		queryObject.setMaxResults(page.getPageSize());
	}
}
