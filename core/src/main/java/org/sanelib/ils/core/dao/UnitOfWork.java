package org.sanelib.ils.core.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManagerFactory;

public class UnitOfWork {

    private EntityManagerFactory entityManagerFactory;
    private Session currentSession;
	private Transaction currentTransaction;

    public UnitOfWork(EntityManagerFactory entityManagerFactory){
        this.entityManagerFactory = entityManagerFactory;
    }

	public void begin() {
		this.currentSession = entityManagerFactory.createEntityManager().unwrap(Session.class);
		this.currentTransaction = currentSession.beginTransaction();
	}

    public Session getCurrentSession() {
		return this.currentSession;
	}

	public void flush() {
		this.currentSession.flush();
	}

	public void clear() {
		this.currentSession.clear();
	}

	public void commit() {
        this.currentTransaction.commit();
        this.currentSession.close();
	}

	public void rollback() {
		if(this.currentTransaction == null){
			return;
		}

		this.currentTransaction.rollback();
	}
}
