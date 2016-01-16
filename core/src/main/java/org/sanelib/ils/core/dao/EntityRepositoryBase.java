package org.sanelib.ils.core.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.*;
import org.hibernate.transform.Transformers;
import org.sanelib.ils.core.domain.entity.Constants;
import org.sanelib.ils.core.domain.entity.DBValue;
import org.sanelib.ils.core.domain.entity.DomainEntity;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings({"rawtypes", "unchecked"})
public abstract class EntityRepositoryBase<T extends DomainEntity> implements EntityRepository<T> {

	protected Class<T> entityClass;

	public EntityRepositoryBase() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
	}

	private UnitOfWork unitOfWork;

	@Autowired
	public void setUnitOfWork(final UnitOfWork unitOfWork) {
		this.unitOfWork = unitOfWork;
	}

	public Session getSession() {
		return unitOfWork.getCurrentSession();
	}

	@Override
	public List<T> loadAll() {
		Criteria criteria = getSession().createCriteria(entityClass);
		return (List<T>) criteria.list();
	}

	@Override
	public T load(final Serializable id) {
		return (T) getSession().load(entityClass, id);

	}

	@Override
	public T get(final Serializable id) {
		return (T) getSession().get(entityClass, id);
	}

    public Integer getNextId() {
        return getNextId("id");
    }

    public Integer getNextId(String columnName) {
        Criteria criteria = this.unitOfWork.getCurrentSession()
                .createCriteria(entityClass)
                .setProjection(Projections.max(columnName));

        List list = criteria.list();

        Integer lastId = list.isEmpty() ? 0 : (Integer) (list.get(0) == null ? 0 : list.get(0));

        return lastId + 1;
    }

	@Override
	public void save(final T entity) {
		getSession().save(entity);
	}

	@Override
	public void update(final T entity) {
		getSession().update(entity);
	}

	@Override
	public void saveOrUpdate(final T entity) {
		getSession().saveOrUpdate(entity);
	}

	@Override
	public T merge(final T entity) {
		return (T) getSession().merge(entity);
	}

	@Override
	public void remove(final T entity) {
		getSession().delete(entity);
	}

	private void setResultColumnNames(final String[] resultColumnNames, SQLQuery query) {
		if (resultColumnNames != null) {
			for (String colName : resultColumnNames) {
				query.addScalar(colName);
			}
		}
	}

	private void validateParams(final String[] names, final Object[] values) {
		if (names == null || values == null) {
			throw new IllegalArgumentException("Both names & values must be provided.");
		}

		if (names.length != values.length) {
			throw new IllegalArgumentException(
					"Both names and values should have same number of elements. " + names.length + " names and " + values.length
							+ " values were found");
		}
	}

	@Override
	public List<T> executeQuery(final String queryString, final String[] paramValues) {
		return executeQuery(queryString, paramValues, null, null);
	}

	@Override
	public List<T> executeQuery(final String queryString, final String[] paramValues, final Class<T> returnType) {
		return executeQuery(queryString, paramValues, null, returnType);
	}

	@Override
	public List<T> executeQuery(final String queryString, final String[] paramValues, final String[] resultColumnNames) {
		return executeQuery(queryString, paramValues, resultColumnNames, null);
	}

	@Override
	public List<T> executeQuery(final String queryString, final String[] paramValues, final String[] resultColumnNames, final Class<T> returnType) {

		SQLQuery query = getSession().createSQLQuery(queryString);
		if (returnType != null) {
			query.addEntity(returnType);
		}
		if (paramValues != null) {
			setParamValues(paramValues, query);
		}
		if (resultColumnNames != null) {
			setResultColumnNames(resultColumnNames, query);
		}
		return (List<T>) query.list();
	}

	@Override
	public List<T> executeQueryObject(final String queryString, Class clazz) {
		if (clazz.equals(String.class)) {
			return getSession().createSQLQuery(queryString).list();
		}
		return getSession().createSQLQuery(queryString).setResultTransformer(Transformers.aliasToBean(clazz)).list();
	}

	@Override
	public List<T> executeQueryObject(final DetachedCriteria detachedCriteria, Class clazz) {
		Criteria criteria = detachedCriteria.getExecutableCriteria(getSession());
		return criteria.setResultTransformer(Transformers.aliasToBean(clazz)).list();

	}

	private void setParamValues(final String[] paramValues, SQLQuery query) {
		if (paramValues != null && paramValues.length > 0) {
			for (int liCnt = 0; liCnt < paramValues.length; liCnt++) {
				query.setString(liCnt, paramValues[liCnt]);
			}
		}
	}

	@Override
	public int executeUpdate(final String queryString, final String[] paramValues) {
		SQLQuery query = getSession().createSQLQuery(queryString);
		setParamValues(paramValues, query);
		return query.executeUpdate();
	}

	@Override
	public T getSafeSingleEntityByColumnAndValue(final String columnName, final Object columnValue) {
		return getSafeSingleEntityByColumnAndValue(new String[] {columnName}, new Object[] {columnValue});
	}

	@Override
	public T getSafeSingleEntityByColumnAndValue(final String[] columnNames, final Object[] columnValues) {
		List<T> list = findByColumnAndValue(columnNames, columnValues, 0, 1);
		if (!list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	private void prepareCriteriaWithPagination(final String[] columnNames, final Object[] columnValues, final int offset, final int size, Criteria criteria, boolean useLike) {
		prepareCriteria(columnNames, columnValues, criteria, useLike);
		addPaginationCriteria(offset, size, criteria);
	}

	private void prepareCriteria(final String[] columnNames, final Object[] columnValues, Criteria criteria, boolean useLike) {
		for (int i = 0; i < columnNames.length; i++) {
			if (columnValues[i] == null || columnValues[i] == DBValue.Null) {
				criteria.add(Restrictions.isNull(columnNames[i]));
			} else if (columnValues[i] == DBValue.NotNull) {
				criteria.add(Restrictions.isNotNull(columnNames[i]));
			} else {
				criteria.add(
						useLike ? Restrictions.like(columnNames[i], columnValues[i]) : Restrictions.eq(columnNames[i], columnValues[i]));
			}
		}
	}

	private void addPaginationCriteria(final int offset, final int size, Criteria criteria) {
		if (offset >= 0) {
			criteria.setFirstResult(offset);
		}
		if (size > 0) {
			criteria.setMaxResults(size);
		}
	}

	@Override
	public List<T> findByColumnAndValue(final String columnName, final Object columnValue) {
		return findByColumnAndValue(columnName, columnValue, -1, 0);
	}

	@Override
	public List<T> findByColumnAndValue(final String columnName, final Object columnValue, final int offset, final int size) {
		return findByColumnAndValue(new String[] {columnName}, new Object[] {columnValue}, offset, size);
	}

	@Override
	public List<T> findByColumnAndValue(final String[] columnNames, final Object[] columnValues) {
		return findByColumnAndValue(columnNames, columnValues, -1, 0);
	}

	@Override
	public List<T> findByColumnAndValue(final String[] columnNames, final Object[] columnValues, final int offset, final int size) {
		validateParams(columnNames, columnValues);
		Criteria criteria = getSession().createCriteria(entityClass);
		prepareCriteriaWithPagination(columnNames, columnValues, offset, size, criteria, false);
		return (List<T>) criteria.list();
	}

	@Override
	public List<T> findColumnAndValueByOrder(final String[] columnNames, final Object[] columnValues, final String orderColumnName,
			final boolean isLikeFlag, final String orderType) {
		Criteria criteria = getSession().createCriteria(entityClass);
		prepareOrderByCriteria(criteria, columnNames, columnValues, orderColumnName, isLikeFlag, orderType);
		return (List<T>) criteria.list();
	}

	private void prepareOrderByCriteria(Criteria criteria, final String[] columnNames, final Object[] columnValues, final String orderColumnName, final boolean isLikeFlag, final String orderType) {
		prepareCriteria(columnNames, columnValues, criteria, isLikeFlag);
		if (orderType != null && orderType.equalsIgnoreCase(Constants.ASCENDING_ORDER)) {
			criteria.addOrder(Order.asc(orderColumnName));
		} else if (orderType != null && orderType.equalsIgnoreCase(Constants.DESCENDING_ORDER)) {
			criteria.addOrder(Order.desc(orderColumnName));
		} else {
			criteria.addOrder(Order.asc(orderColumnName));
		}

	}

	@Override
	public List<T> findColumnAndValueByOrderPagination(final String[] columnNames, final Object[] columnValues, final String orderColumnName, final boolean isLikeFlag, final String orderType, final int offset, final int size) {
		Criteria criteria = getSession().createCriteria(entityClass);
		prepareOrderByCriteria(criteria, columnNames, columnValues, orderColumnName, isLikeFlag, orderType);
		addPaginationCriteria(offset, size, criteria);
		return (List<T>) criteria.list();
	}

	@Override
	public List<String> getListString(final String query) {
		Query hQuery = getSession().createQuery(query);
		return (List<String>) hQuery.list();
	}

	@Override
	public List getListString(final DetachedCriteria deCriteria) {
		Criteria criteria = deCriteria.getExecutableCriteria(getSession());
		return criteria.list();
	}

	@Override
	public List<T> findByCriteria(final DetachedCriteria deCriteria) {
		Criteria criteria = deCriteria.getExecutableCriteria(getSession());
		return (List<T>) criteria.list();
	}
}
