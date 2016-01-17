package org.sanelib.ils.core.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HibernateHelper {

    @Autowired
    UnitOfWork unitOfWork;

    public Integer getNextId(Class clazz) {
        return getNextId(clazz, "id");
    }

    public Integer getNextId(Class clazz, String columnName) {
        Criteria criteria = this.unitOfWork.getCurrentSession()
                .createCriteria(clazz)
                .setProjection(Projections.max(columnName));

        List list = criteria.list();

        Integer lastId = list.isEmpty() ? 0 : (Integer) (list.get(0) == null ? 0 : list.get(0));

        return lastId + 1;
    }
}
