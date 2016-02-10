package org.sanelib.ils.core.dao;

import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class UnitOfWork {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private Session currentSession;
    private EntityTransaction transaction;

    public UnitOfWork(EntityManagerFactory entityManagerFactory){
        this.entityManagerFactory = entityManagerFactory;
    }

	public void begin() {
        this.entityManager = entityManagerFactory.createEntityManager();
        this.transaction = entityManager.getTransaction();
        this.transaction.begin();
        this.currentSession = entityManager.unwrap(Session.class);
	}

    public Session getCurrentSession() {
		return this.currentSession;
	}

    public EntityManager getEntityManager(){
        return this.entityManager;
    }

	public void flush() {
		this.currentSession.flush();
	}

	public void clear() {
		this.currentSession.clear();
	}

	public void commit() {
        this.transaction.commit();
        this.entityManager.close();
	}

	public void rollback() {
		if(this.transaction == null){
			return;
		}

		this.transaction.rollback();

        if(this.entityManager.isOpen()){
            this.entityManager.close();
        }
	}
}
