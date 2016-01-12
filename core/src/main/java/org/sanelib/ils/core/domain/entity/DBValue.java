package org.sanelib.ils.core.domain.entity;

import org.hibernate.criterion.Restrictions;

public enum DBValue {
	/**
	 * This represents that on field only {@link Restrictions#isNotNull(String)}
	 * is to be put. Not a criteria that matches a specific value of the field
	 */
	NotNull,

	/**
	 * This represents that on field only {@link Restrictions#isNull(String)} is
	 * to be put.
	 */
	Null
}
