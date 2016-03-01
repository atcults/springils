package org.sanelib.ils.core.dao.read.admin.mapper;

import org.sanelib.ils.core.dao.read.DataResultSet;
import org.sanelib.ils.core.dao.read.ViewMapper;
import org.sanelib.ils.core.domain.view.admin.PatronView;
import org.sanelib.ils.core.enums.PatronType;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Objects;

@Component
public class PatronMapper implements ViewMapper<PatronView> {

    public PatronView map(final DataResultSet rs) throws SQLException {

        final String viewName = "patron";

        final PatronView patronView = new PatronView();

        patronView.setLibraryId(rs.getInt(viewName, "library_id"));
        patronView.setCode(rs.getString(viewName, "patron_id"));
        patronView.setPatronCategoryId(rs.getInt(viewName, "patron_category_id"));
        patronView.setOwns(rs.getString(viewName, "owns"));
        patronView.setOtherLibraryPatronId(rs.getInt(viewName, "other_library_patron_id"));
        patronView.setLibraryPatronId(rs.getInt(viewName, "library_patron_id"));
        patronView.setPatronType(PatronType.getByValue(rs.getString(viewName, "patron_type")));
        patronView.setDeptId(rs.getInt(viewName, "dept_id"));
        patronView.setFirstName(rs.getString(viewName, "fname"));
        patronView.setMiddleName(rs.getString(viewName, "mname"));
        patronView.setLastName(rs.getString(viewName, "lname"));
        patronView.setAddressLine1(rs.getString(viewName, "address1"));
        patronView.setAddressLine2(rs.getString(viewName, "address2"));
        patronView.setCity(rs.getString(viewName, "city"));
        patronView.setState(rs.getString(viewName, "state"));
        patronView.setCountry(rs.getString(viewName, "country"));
        patronView.setPin(rs.getString(viewName, "pin"));
        patronView.setPhone1(rs.getString(viewName, "phone1"));
        patronView.setPhone2(rs.getString(viewName, "phone2"));
        patronView.setFax(rs.getString(viewName, "fax"));
        patronView.setEmail(rs.getString(viewName, "email"));
        patronView.setPermanentAddressLine1(rs.getString(viewName, "paddress1"));
        patronView.setPermanentAddressLine2(rs.getString(viewName, "paddress2"));
        patronView.setPermanentCity(rs.getString(viewName, "pcity"));
        patronView.setPermanentState(rs.getString(viewName, "pstate"));
        patronView.setPermanentCountry(rs.getString(viewName, "pcountry"));
        patronView.setPermanentPin(rs.getString(viewName, "ppin"));
        patronView.setPermanentPhone1(rs.getString(viewName, "pphone1"));
        patronView.setPermanentPhone2(rs.getString(viewName, "pphone2"));
        patronView.setPermanentFax(rs.getString(viewName, "pfax"));
        patronView.setPermanentEmail(rs.getString(viewName, "pemail"));
        patronView.setMembershipFrom(rs.getDate(viewName, "membership_start_date"));
        patronView.setMembershipTo(rs.getDate(viewName, "membership_expiry_date"));
        patronView.setDelinquencyReason(rs.getString(viewName, "delinquency_reason"));
        patronView.setCommonEmail(Objects.equals(rs.getString(viewName, "common_email"), "Y"));
        patronView.setCommonInstantMsg(Objects.equals(rs.getString(viewName, "common_instant_msg"), "Y"));
        patronView.setCommonPrint(Objects.equals(rs.getString(viewName, "common_print"), "Y"));
        patronView.setUserPassword(rs.getString(viewName, "user_password"));
        patronView.setCourseId(rs.getInt(viewName, "course_id"));
        patronView.setCustom(rs.getString(viewName, "custom"));
        patronView.setPrivilege(rs.getString(viewName, "privilege"));
        patronView.setTwitterId(rs.getString(viewName, "twitter_id"));
        patronView.setFacebookId(rs.getString(viewName, "facebook_id"));
        patronView.setSubLocationId(rs.getInt(viewName, "sub_location_id"));
        patronView.setLoginId(rs.getString(viewName, "login_id"));
        patronView.setAuthenticateLocalDatabase(rs.getString(viewName, "authenticate_localdatabase"));
        patronView.setSendToAddress(Objects.equals(rs.getString(viewName, "send_to_address"), "A"));
        patronView.setActive(Objects.equals(rs.getString(viewName, "status"), "A"));
        patronView.setCreatedOn(rs.getDate(viewName, "created_on"));

        return patronView;
    }
}

