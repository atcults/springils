package org.sanelib.ils.core.commands.library;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.domain.entity.Library;

import java.util.Date;

public class AddLibrary implements ProcessCommand {

    private String name;
    private String serialMaster;
    private String catalogueMaster;
    private String acquisitionsMaster;
    private Date createdOn;
    private String acquisitionStatus;
    private String cataloguingStatus;
    private String smStatus;
    private Integer hostLibraryId;
    private String firstAddress;
    private String secondAddress;
    private String city;
    private String state;
    private String pin;
    private String firstPhoneNumber;
    private String email;
    private String secondPhoneNumber;
    private String fax;
    private String country;
    private String networkName;
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
    public Class getRootEntityClass() {
        return Library.class;
    }

    @Override
    public String getRootEntityName() {
        return "domain.entity.library";
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

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getAcquisitionStatus() {
        return acquisitionStatus;
    }

    public void setAcquisitionStatus(String acquisitionStatus) {
        this.acquisitionStatus = acquisitionStatus;
    }

    public String getCataloguingStatus() {
        return cataloguingStatus;
    }

    public void setCataloguingStatus(String cataloguingStatus) {
        this.cataloguingStatus = cataloguingStatus;
    }

    public String getSmStatus() {
        return smStatus;
    }

    public void setSmStatus(String smStatus) {
        this.smStatus = smStatus;
    }

    public Integer getHostLibraryId() {
        return hostLibraryId;
    }

    public void setHostLibraryId(Integer hostLibraryId) {
        this.hostLibraryId = hostLibraryId;
    }

    public String getFirstAddress() {
        return firstAddress;
    }

    public void setFirstAddress(String firstAddress) {
        this.firstAddress = firstAddress;
    }

    public String getSecondAddress() {
        return secondAddress;
    }

    public void setSecondAddress(String secondAddress) {
        this.secondAddress = secondAddress;
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

    public String getFirstPhoneNumber() {
        return firstPhoneNumber;
    }

    public void setFirstPhoneNumber(String firstPhoneNumber) {
        this.firstPhoneNumber = firstPhoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecondPhoneNumber() {
        return secondPhoneNumber;
    }

    public void setSecondPhoneNumber(String secondPhoneNumber) {
        this.secondPhoneNumber = secondPhoneNumber;
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

    public String getNetworkName() {
        return networkName;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
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

