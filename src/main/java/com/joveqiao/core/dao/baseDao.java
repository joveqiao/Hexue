/*package com.joveqiao.core.dao;

public class baseDao {
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    protected void save(Object obj) {
        getSession().save(obj);
    }

    protected <T> T get(Class<T> clazz, int id) {
        return (T) getSession().get(clazz, id);
    }

    protected <T> List<T> findByProperty(Class<T> clazz, String property, Object value) {
        return getSession().createCriteria(clazz).add(eq(property, value)).list();
    }

    protected <T> List<T> findAll(Class<T> clazz) {
        return getSession().createCriteria(clazz).list();
    }

    protected void update(Object obj) {
        getSession().update(obj);
    }

    protected void delete(Class clazz, int id) {
        getSession().delete(get(clazz, id));
    }

    protected void delete(Object obj) {
        getSession().delete(obj);
    }

}*/