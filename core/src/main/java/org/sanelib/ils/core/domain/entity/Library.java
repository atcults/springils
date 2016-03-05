package org.sanelib.ils.core.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "library")
public class Library implements DomainEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "library_id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (this.id != 0 && this.id != id) {
            throw new IllegalStateException("The ID must not be changed after it is set.");
        }
        this.id = id;
    }

    @Column(name = "library_name")
    private String name;

    @Column(name = "serialmaster", length = 18)
    private String serialMaster;

    @Column(name = "cataloguemaster", length = 18)
    private String catalogueMaster;

    @Column(name = "acquisitionsmaster", length = 18)
    private String acquisitionsMaster;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "acquisition_status", length = 10)
    private String acquisitionStatus;

    @Column(name = "cataloguing_status", length = 10)
    private String cataloguingStatus;

    @Column(name = "sm_status", length = 10)
    private String smStatus;

    @Column(name = "hostlibraryid")
    private Integer hostLibraryId;

    @Column(name = "address1")
    private String addressLine1;

    @Column(name = "address2")
    private String addressLine2;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "pin")
    private String pin;

    @Column(name = "phone_number1")
    private String primaryPhone;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number2")
    private String secondaryPhone;

    @Column(name = "fax")
    private String fax;

    @Column(name = "country")
    private String country;

    @Column(name = "network_name")
    private String networkName;

    @Column(name = "search_forms")
    private String searchForms;

    @Column(name = "facebook_widget")
    private String facebookWidget;

    @Column(name = "twitter_widget")
    private String twitterWidget;

    @Column(name = "about_library")
    private String aboutLibrary;

    @Column(name = "about_organization")
    private String aboutOrganization;

    @Column(name = "library_timings")
    private String libraryTimings;

    @Column(name = "contact_us")
    private String contactUs;

    @Column(name = "map_widget")
    private String mapWidget;

    @Column(name = "description")
    private String description;

    @Column(name = "web_statistics")
    private String webStatistics;

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
    public int hashCode() {
        return this.id;
    }

    @PrePersist
    public void prePersist() {

        acquisitionStatus = "MASTER";
        cataloguingStatus = "MASTER";
        smStatus = "MASTER";
        networkName = name;
        hostLibraryId = id;

        if(createdOn == null){

            createdOn = new Date();
        }
    }
}
