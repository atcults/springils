package org.sanelib.ils.core.dao.read.admin.mapper;

import org.sanelib.ils.core.dao.read.DataResultSet;
import org.sanelib.ils.core.dao.read.ViewMapper;
import org.sanelib.ils.core.domain.view.admin.PatronCategoryView;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Objects;

@Component
public class PatronCategoryMapper implements ViewMapper<PatronCategoryView> {

    public PatronCategoryView map(final DataResultSet rs) throws SQLException {

        final String viewName = "patron_category";

        final PatronCategoryView patronCategoryView = new PatronCategoryView();

        patronCategoryView.setLibraryId(rs.getInt(viewName, "library_id"));
        patronCategoryView.setId(rs.getInt(viewName, "patron_category_id"));
        patronCategoryView.setName(rs.getString(viewName, "patron_category_name"));
        patronCategoryView.setAllowILLFromNet(Objects.equals(rs.getString(viewName, "ill_thru_net"), "Y"));
        patronCategoryView.setAllowRenewalFromNet(Objects.equals(rs.getString(viewName, "renewal_thru_net"), "Y"));
        patronCategoryView.setAllowMultipleCopies(Objects.equals(rs.getString(viewName, "allow_multiple_copies"), "Y"));
        patronCategoryView.setOverallLoanLimit(rs.getInt(viewName, "overall_loan_limit"));
        patronCategoryView.setAcqWorkflow(rs.getString(viewName, "acq_workflow"));

        return patronCategoryView;
    }
}

