package org.sanelib.ils.core.dao.read.admin.mapper;

import org.sanelib.ils.core.dao.read.DataResultSet;
import org.sanelib.ils.core.dao.read.ViewMapper;
import org.sanelib.ils.core.domain.view.admin.LibraryView;
import org.sanelib.ils.core.domain.view.admin.PatronCategoryView;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Objects;

@Component
public class PatronCategoryMapper implements ViewMapper<PatronCategoryView> {

    public PatronCategoryView map(final DataResultSet rs) throws SQLException {

        final String viewName = "patron_category";

        final PatronCategoryView view = new PatronCategoryView();
        view.setLibraryId(rs.getInt(viewName, "library_id"));
        view.setId(rs.getInt(viewName, "patron_category_id"));
        view.setName(rs.getString(viewName, "patron_category_name"));
        view.setAllowILLFromNet(Objects.equals(rs.getString(viewName, "ill_thru_net"), "Y"));
        view.setAllowRenewalFromNet(Objects.equals(rs.getString(viewName, "renewal_thru_net"), "Y"));
        view.setAllowMultipleCopies(Objects.equals(rs.getString(viewName, "allow_multiple_copies"), "Y"));
        view.setOverallLoanLimit(rs.getInt(viewName, "overall_loan_limit"));
        view.setAcqWorkflow(rs.getString(viewName, "acq_workflow"));
        view.setEntryDate(rs.getDate(viewName, "entry_date"));
        return view;
    }
}

