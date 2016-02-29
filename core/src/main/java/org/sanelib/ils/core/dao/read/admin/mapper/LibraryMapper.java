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
        libraryView.setSerialMaster(rs.getString(viewName, "serialmaster"));
        libraryView.setCatalogueMaster(rs.getString(viewName, "cataloguemaster"));
        libraryView.setAcquisitionsMaster(rs.getString(viewName, "acquisitionsmaster"));
        libraryView.setCreatedOn(rs.getDate(viewName, "created_on"));
        libraryView.setAcquisitionStatus(rs.getString(viewName, "acquisition_status"));
        libraryView.setCataloguingStatus(rs.getString(viewName, "cataloguing_status"));
        libraryView.setSmStatus(rs.getString(viewName, "sm_status"));
        libraryView.setHostLibraryId(rs.getInt(viewName, "hostlibraryid"));
        libraryView.setAddressLine1(rs.getString(viewName, "address1"));
        libraryView.setAddressLine2(rs.getString(viewName, "address2"));
        libraryView.setCity(rs.getString(viewName, "city"));
        libraryView.setState(rs.getString(viewName, "state"));
        libraryView.setPin(rs.getString(viewName, "pin"));
        libraryView.setPrimaryPhone(rs.getString(viewName, "phone_number1"));
        libraryView.setEmail(rs.getString(viewName, "email"));
        libraryView.setSecondaryPhone(rs.getString(viewName, "phone_number2"));
        libraryView.setFax(rs.getString(viewName, "fax"));
        libraryView.setCountry(rs.getString(viewName, "country"));
        libraryView.setNetworkName(rs.getString(viewName, "network_name"));
        libraryView.setSearchForms(rs.getString(viewName, "search_forms"));
        libraryView.setFacebookWidget(rs.getString(viewName, "facebook_widget"));
        libraryView.setTwitterWidget(rs.getString(viewName, "twitter_widget"));
        libraryView.setAboutLibrary(rs.getString(viewName, "about_library"));
        libraryView.setAboutOrganization(rs.getString(viewName, "about_organization"));
        libraryView.setLibraryTimings(rs.getString(viewName, "library_timings"));
        libraryView.setContactUs(rs.getString(viewName, "contact_us"));
        libraryView.setMapWidget(rs.getString(viewName, "map_widget"));
        libraryView.setDescription(rs.getString(viewName, "description"));
        libraryView.setWebStatistics(rs.getString(viewName, "web_statistics"));

        return libraryView;
    }
}

