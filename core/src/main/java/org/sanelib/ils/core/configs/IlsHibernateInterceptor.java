package org.sanelib.ils.core.configs;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.sanelib.ils.core.domain.entity.RequireBeforePersist;

import java.io.Serializable;
import java.util.Iterator;

public class IlsHibernateInterceptor extends EmptyInterceptor {
    @Override
    public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        System.out.println("before delete is called");
        super.onDelete(entity, id, state, propertyNames, types);
    }

    @Override
    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
        System.out.println("before update is called");
        return super.onFlushDirty(entity, id, currentState, previousState, propertyNames, types);
    }

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        System.out.println("onSave is called");
        if(entity instanceof RequireBeforePersist){
            ((RequireBeforePersist) entity).prePersist();
        }
        return super.onSave(entity, id, state, propertyNames, types);
    }

    @Override
    public void postFlush(Iterator entities) {
        System.out.println("afterSave is called");
        super.postFlush(entities);
    }

    @Override
    public void preFlush(Iterator entities) {
        System.out.println("before Save is called");
        super.preFlush(entities);
    }

    @Override
    public String getEntityName(Object object) {
        return super.getEntityName(object);
    }
}
