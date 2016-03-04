package org.sanelib.ils.core.domain.view.admin;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.sanelib.ils.core.domain.view.DomainView;
import org.sanelib.ils.core.domain.view.ViewWithCode;
import org.sanelib.ils.core.enums.PatronType;

import java.util.Date;

public class PatronView implements DomainView, ViewWithCode {

    private Integer libraryId;
    private String code;
    private Integer patronCategoryId;
    private String owns;
    private Integer otherLibraryPatronId;
    private Integer libraryPatronId;
    private PatronType patronType;
    private Integer deptId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country;
    private String pin;
    private String phone1;
    private String phone2;
    private String fax;
    private String email;
    private String permanentAddressLine1;
    private String permanentAddressLine2;
    private String permanentCity;
    private String permanentState;
    private String permanentCountry;
    private String permanentPin;
    private String permanentPhone1;
    private String permanentPhone2;
    private String permanentFax;
    private String permanentEmail;
    private Date membershipFrom;
    private Date membershipTo;
    private String delinquencyReason;
    private boolean commonEmail;
    private boolean commonInstantMsg;
    private boolean commonPrint;
    private String userPassword;
    private Integer courseId;
    private String custom;
    private String privilege;
    private String twitterId;
    private String facebookId;
    private Integer subLocationId;
    private String loginId;
    private String authenticateLocalDatabase;
    private boolean sendToAddress;
    private boolean isActive;
    private Date createdOn;

    public Integer getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
    }

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getPatronCategoryId() {
        return patronCategoryId;
    }

    public void setPatronCategoryId(Integer patronCategoryId) {
        this.patronCategoryId = patronCategoryId;
    }

    public String getOwns() {
        return owns;
    }

    public void setOwns(String owns) {
        this.owns = owns;
    }

    public Integer getOtherLibraryPatronId() {
        return otherLibraryPatronId;
    }

    public void setOtherLibraryPatronId(Integer otherLibraryPatronId) {
        this.otherLibraryPatronId = otherLibraryPatronId;
    }

    public Integer getLibraryPatronId() {
        return libraryPatronId;
    }

    public void setLibraryPatronId(Integer libraryPatronId) {
        this.libraryPatronId = libraryPatronId;
    }

    public PatronType getPatronType() {
        return patronType;
    }

    public void setPatronType(PatronType patronType) {
        this.patronType = patronType;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPermanentAddressLine1() {
        return permanentAddressLine1;
    }

    public void setPermanentAddressLine1(String permanentAddressLine1) {
        this.permanentAddressLine1 = permanentAddressLine1;
    }

    public String getPermanentAddressLine2() {
        return permanentAddressLine2;
    }

    public void setPermanentAddressLine2(String permanentAddressLine2) {
        this.permanentAddressLine2 = permanentAddressLine2;
    }

    public String getPermanentCity() {
        return permanentCity;
    }

    public void setPermanentCity(String permanentCity) {
        this.permanentCity = permanentCity;
    }

    public String getPermanentState() {
        return permanentState;
    }

    public void setPermanentState(String permanentState) {
        this.permanentState = permanentState;
    }

    public String getPermanentCountry() {
        return permanentCountry;
    }

    public void setPermanentCountry(String permanentCountry) {
        this.permanentCountry = permanentCountry;
    }

    public String getPermanentPin() {
        return permanentPin;
    }

    public void setPermanentPin(String permanentPin) {
        this.permanentPin = permanentPin;
    }

    public String getPermanentPhone1() {
        return permanentPhone1;
    }

    public void setPermanentPhone1(String permanentPhone1) {
        this.permanentPhone1 = permanentPhone1;
    }

    public String getPermanentPhone2() {
        return permanentPhone2;
    }

    public void setPermanentPhone2(String permanentPhone2) {
        this.permanentPhone2 = permanentPhone2;
    }

    public String getPermanentFax() {
        return permanentFax;
    }

    public void setPermanentFax(String permanentFax) {
        this.permanentFax = permanentFax;
    }

    public String getPermanentEmail() {
        return permanentEmail;
    }

    public void setPermanentEmail(String permanentEmail) {
        this.permanentEmail = permanentEmail;
    }

    public Date getMembershipFrom() {
        return membershipFrom;
    }

    public void setMembershipFrom(Date membershipFrom) {
        this.membershipFrom = membershipFrom;
    }

    public Date getMembershipTo() {
        return membershipTo;
    }

    public void setMembershipTo(Date membershipTo) {
        this.membershipTo = membershipTo;
    }

    public String getDelinquencyReason() {
        return delinquencyReason;
    }

    public void setDelinquencyReason(String delinquencyReason) {
        this.delinquencyReason = delinquencyReason;
    }

    public boolean isCommonEmail() {
        return commonEmail;
    }

    public void setCommonEmail(boolean commonEmail) {
        this.commonEmail = commonEmail;
    }

    public boolean isCommonInstantMsg() {
        return commonInstantMsg;
    }

    public void setCommonInstantMsg(boolean commonInstantMsg) {
        this.commonInstantMsg = commonInstantMsg;
    }

    public boolean isCommonPrint() {
        return commonPrint;
    }

    public void setCommonPrint(boolean commonPrint) {
        this.commonPrint = commonPrint;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCustom() {
        return custom;
    }

    public void setCustom(String custom) {
        this.custom = custom;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public String getTwitterId() {
        return twitterId;
    }

    public void setTwitterId(String twitterId) {
        this.twitterId = twitterId;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public Integer getSubLocationId() {
        return subLocationId;
    }

    public void setSubLocationId(Integer subLocationId) {
        this.subLocationId = subLocationId;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getAuthenticateLocalDatabase() {
        return authenticateLocalDatabase;
    }

    public void setAuthenticateLocalDatabase(String authenticateLocalDatabase) {
        this.authenticateLocalDatabase = authenticateLocalDatabase;
    }

    public boolean isSendToAddress() {
        return sendToAddress;
    }

    public void setSendToAddress(boolean sendToAddress) {
        this.sendToAddress = sendToAddress;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
