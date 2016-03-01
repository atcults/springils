package org.sanelib.ils.core.domain.view.admin;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.sanelib.ils.core.domain.view.DomainView;
import org.sanelib.ils.core.domain.view.ViewWithId;

public class LibraryView implements DomainView, ViewWithId {

    private Integer id;
    private String name;
    private String serialMaster;
    private String catalogueMaster;
    private String acquisitionsMaster;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String pin;
    private String primaryPhone;
    private String email;
    private String secondaryPhone;
    private String fax;
    private String country;
    private String searchForms;
    private String facebookWidget;
    private String twitterWidget;
    private String aboutLibrary;
    private String aboutOrganization;
    private String libraryTimings;
    private String contactUs;
    private String mapWidget;
    private String description;
    private String webStatistics;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerialMaster() {
        return serialMaster;
    }

    public void setSerialMaster(String serialMaster) {
        this.serialMaster = serialMaster;
    }

    public String getCatalogueMaster() {
        return catalogueMaster;
    }

    public void setCatalogueMaster(String catalogueMaster) {
        this.catalogueMaster = catalogueMaster;
    }

    public String getAcquisitionsMaster() {
        return acquisitionsMaster;
    }

    public void setAcquisitionsMaster(String acquisitionsMaster) {
        this.acquisitionsMaster = acquisitionsMaster;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPrimaryPhone() {
        return primaryPhone;
    }

    public void setPrimaryPhone(String primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecondaryPhone() {
        return secondaryPhone;
    }

    public void setSecondaryPhone(String secondaryPhone) {
        this.secondaryPhone = secondaryPhone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSearchForms() {
        return searchForms;
    }

    public void setSearchForms(String searchForms) {
        this.searchForms = searchForms;
    }

    public String getFacebookWidget() {
        return facebookWidget;
    }

    public void setFacebookWidget(String facebookWidget) {
        this.facebookWidget = facebookWidget;
    }

    public String getTwitterWidget() {
        return twitterWidget;
    }

    public void setTwitterWidget(String twitterWidget) {
        this.twitterWidget = twitterWidget;
    }

    public String getAboutLibrary() {
        return aboutLibrary;
    }

    public void setAboutLibrary(String aboutLibrary) {
        this.aboutLibrary = aboutLibrary;
    }

    public String getAboutOrganization() {
        return aboutOrganization;
    }

    public void setAboutOrganization(String aboutOrganization) {
        this.aboutOrganization = aboutOrganization;
    }

    public String getLibraryTimings() {
        return libraryTimings;
    }

    public void setLibraryTimings(String libraryTimings) {
        this.libraryTimings = libraryTimings;
    }

    public String getContactUs() {
        return contactUs;
    }

    public void setContactUs(String contactUs) {
        this.contactUs = contactUs;
    }

    public String getMapWidget() {
        return mapWidget;
    }

    public void setMapWidget(String mapWidget) {
        this.mapWidget = mapWidget;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebStatistics() {
        return webStatistics;
    }

    public void setWebStatistics(String webStatistics) {
        this.webStatistics = webStatistics;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}


