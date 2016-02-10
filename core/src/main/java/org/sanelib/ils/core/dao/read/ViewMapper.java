package org.sanelib.ils.core.dao.read;

import org.sanelib.ils.core.domain.view.DomainView;

import java.sql.SQLException;

public interface ViewMapper<T extends DomainView> {
    T map(final DataResultSet rs) throws SQLException;
}
