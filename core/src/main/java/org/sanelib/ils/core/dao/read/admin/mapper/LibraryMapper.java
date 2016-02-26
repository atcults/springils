package org.sanelib.ils.core.dao.read.admin.mapper;

import org.sanelib.ils.core.dao.read.DataResultSet;
import org.sanelib.ils.core.dao.read.ViewMapper;
import org.sanelib.ils.core.domain.view.admin.LibraryView;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class LibraryMapper implements ViewMapper<LibraryView> {

    public LibraryView map(final DataResultSet rs) throws SQLException {

        final String viewName = "library";

        final LibraryView libraryView = new LibraryView();

        libraryView.setId(rs.getInt(viewName, "library_id"));
        libraryView.setName(rs.getString(viewName, "library_name"));
        libraryView.setCity(rs.getString(viewName, "city"));
        libraryView.setState(rs.getString(viewName, "state"));
        libraryView.setCountry(rs.getString(viewName, "country"));libraryView.setSerialMaster(rs.getString(library , "serialmaster"));libraryView.setCatalogueMaster(rs.getString(library , "cataloguemaster"));
        libraryView.setAcquisitionsMaster(rs.getString(library , "acquisitionsmaster"));
        libraryView.setCreatedOn(rs.getDate(library , "created_on"));
        libraryView.setAcquisitionStatus(rs.getString(library , "acquisition_status"));
        libraryView.setCataloguingStatus(rs.getString(library , "cataloguing_status"));
        libraryView.setSmStatus(rs.getString(library , "sm_status"));
        libraryView.setHostLibraryId(rs.getInt(library , "hostlibraryid"));
        libraryView.setFirstAddress(rs.getString(library , "address1"));
        libraryView.setSecondAddress(rs.getString(library , "address2"));
        libraryView.setPin(rs.getString(library, "pin"));
        libraryView.setFirstPhoneNumber(rs.getString(library , "phone_number1"));
        libraryView.setEmail(rs.getString(library , "email"));
        libraryView.setSecondPhoneNumber(rs.getString(library , "phone_number2"));
        libraryView.setFax(rs.getString(library , "fax"));
        libraryView.setNetworkName(rs.getString(library , "network_name"));
        libraryView.setSearchForms(rs.getString(library , "search_forms"));
        libraryView.setFacebookWidget(rs.getString(library , "facebook_widget"));
        libraryView.setTwitterWidget(rs.getString(library , "twitter_widget"));
        libraryView.setAboutLibrary(rs.getString(library , "about_library"));
        libraryView.setAboutOrganization(rs.getString(library , "about_organization"));
        libraryView.setLibraryTimings(rs.getString(library , "library_timings"));
        libraryView.setContactUs(rs.getString(library , "contact_us"));
        libraryView.setMapWidget(rs.getString(library , "map_widget"));
        libraryView.setDescription(rs.getString(library , "description"));
        libraryView.setWebStatistics(rs.getString(library , "web_statistics"));

        return libraryView;
    }
}

