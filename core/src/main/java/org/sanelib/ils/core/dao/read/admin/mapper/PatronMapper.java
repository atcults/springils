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

        final PatronView view = new PatronView();

        view.setLibraryId(rs.getInt(viewName, "library_id"));
        view.setCode(rs.getString(viewName, "patron_id"));
        view.setPatronCategoryId(rs.getInt(viewName, "patron_category_id"));
        view.setOwns(rs.getString(viewName, "owns"));
        view.setOtherLibraryPatronId(rs.getInt(viewName, "other_library_patron_id"));
        view.setLibraryPatronId(rs.getInt(viewName, "library_patron_id"));
        view.setPatronType(PatronType.getByValue(rs.getString(viewName,"patron_type")));
        view.setDeptId(rs.getInt(viewName, "dept_id"));
        view.setFirstName(rs.getString(viewName, "fname"));
        view.setMiddleName(rs.getString(viewName, "mname"));
        view.setLastName(rs.getString(viewName, "lname"));
        view.setAddress1(rs.getString(viewName, "address1"));
        view.setAddress2(rs.getString(viewName, "address2"));
        view.setCity(rs.getString(viewName, "city"));
        view.setState(rs.getString(viewName, "state"));
        view.setCountry(rs.getString(viewName, "country"));
        view.setPin(rs.getString(viewName, "pin"));
        view.setPhone1(rs.getString(viewName, "phone1"));
        view.setPhone2(rs.getString(viewName, "phone2"));
        view.setFax(rs.getString(viewName, "fax"));
        view.setEmail(rs.getString(viewName, "email"));
        view.setPermanentAddress1(rs.getString(viewName, "paddress1"));
        view.setPermanentAddress2(rs.getString(viewName, "paddress2"));
        view.setPermanentCity(rs.getString(viewName, "pcity"));
        view.setPermanentState(rs.getString(viewName, "pstate"));
        view.setPermanentCountry(rs.getString(viewName, "pcountry"));
        view.setPermanentPin(rs.getString(viewName, "ppin"));
        view.setPermanentPhone1(rs.getString(viewName, "pphone1"));
        view.setPermanentPhone2(rs.getString(viewName, "pphone2"));
        view.setPermanentFax(rs.getString(viewName, "pfax"));
        view.setPermanentEmail(rs.getString(viewName, "pemail"));
        view.setMembershipFrom(rs.getDate(viewName, "membership_start_date"));
        view.setMembershipTo(rs.getDate(viewName, "membership_expiry_date"));
        view.setDelinquencyReason(rs.getString(viewName, "delinquency_reason"));
        view.setCommonEmail(Objects.equals(rs.getString(viewName, "common_email"), "Y"));
        view.setCommonInstantMsg(Objects.equals(rs.getString(viewName, "common_instant_msg"), "Y"));
        view.setCommonPrint(Objects.equals(rs.getString(viewName, "common_print"), "Y"));
        view.setUserPassword(rs.getString(viewName, "user_password"));
        view.setCourseId(rs.getInt(viewName, "course_id"));
        view.setCustom(rs.getString(viewName, "custom"));
        view.setPrivilege(rs.getString(viewName, "privilege"));
        view.setTwitterId(rs.getString(viewName, "twitter_id"));
        view.setFacebookId(rs.getString(viewName, "facebook_id"));
        view.setSubLocationId(rs.getInt(viewName, "sub_location_id"));
        view.setLoginId(rs.getString(viewName, "login_id"));
        view.setAuthenticateLocalDatabase(rs.getString(viewName, "authenticate_localdatabase"));
        view.setSendToAddress(Objects.equals(rs.getString(viewName, "send_to_address"), "A"));
        view.setActive(Objects.equals(rs.getString(viewName, "status"), "A"));
        view.setCreatedOn(rs.getDate(viewName, "created_on"));

        return view;
    }
}

