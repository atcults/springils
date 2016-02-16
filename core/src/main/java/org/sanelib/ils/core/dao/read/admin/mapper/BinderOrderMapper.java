package org.sanelib.ils.core.dao.read.admin.mapper;

import org.sanelib.ils.core.dao.read.DataResultSet;
import org.sanelib.ils.core.dao.read.ViewMapper;
import org.sanelib.ils.core.domain.view.admin.BinderOrderView;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Objects;

@Component
public class BinderOrderMapper implements ViewMapper<BinderOrderView> {

    public BinderOrderView map(final DataResultSet rs) throws SQLException {

        final String viewName = "cir_binder_order";

        final BinderOrderView view = new BinderOrderView();
        view.setLibraryId(rs.getInt(viewName, "library_id"));
        view.setId(rs.getInt(viewName, "patron_category_id"));
        view.setBinderId(rs.getInt(viewName, "binder_id"));
        view.setOrderDate(rs.getDate(viewName, "order_date"));
        view.setDueDate(rs.getDate(viewName, "due_date"));
        view.setReturnedDate(rs.getDate(viewName, "returned_date"));
        view.setFormLetterNo(rs.getString(viewName, "form_letter_no"));
        view.setSubject(rs.getString(viewName, "subject"));
        view.setContent(rs.getString(viewName, "content"));
        view.setMailStatus(Objects.equals(rs.getString(viewName, "mail_status"),"Y"));
        view.setPrintStatus(Objects.equals(rs.getString(viewName, "print_status"),"Y"));
        view.setStatus(rs.getString(viewName, "status"));
        view.setEntryId(rs.getString(viewName, "entry_id"));
        view.setEntryDate(rs.getDate(viewName, "entry_date"));
        return view;
    }
}

