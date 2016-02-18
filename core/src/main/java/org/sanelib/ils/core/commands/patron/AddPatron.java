package org.sanelib.ils.core.commands.patron;


import org.sanelib.ils.core.commands.ProcessCommandWithCode;
import org.sanelib.ils.core.commands.ProcessCommandWithLibraryId;
import org.sanelib.ils.core.domain.entity.Patron;
import org.sanelib.ils.core.enums.PatronType;

import java.util.Date;

public class AddPatron extends ProcessCommandWithLibraryId implements ProcessCommandWithCode {

    @Override
    public Class getRootEntityClass() {
        return Patron.class;
    }

    @Override
    public String getRootEntityName() {
        return "domain.entity.patron";
    }

    private String code;
    private Integer patronCategoryId;
    private String isOnline;
    private String owns;
    private Date createdOn;
    private Integer otherLibraryPatronId;
    private Integer libraryPatronId;
    private PatronType patronType;
    private Integer deptId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String country;
    private String pin;
    private String phone1;
    private String phone2;
    private String fax;
    private String email;
    private String permanentAddress1;
    private String permanentAddress2;
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
    private Date entryDate;
    private String userPassword;
    private Integer courseId;
    private String status;
    private String sendToAddress;
    private String custom;
    private String privilege;
    private String twitterId;
    private String facebookId;
    private Integer subLocationId;
    private String loginId;
    private String authenticateLocalDatabase;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    public Integer getPatronCategoryId() {
        return patronCategoryId;
    }

    public void setPatronCategoryId(Integer patronCategoryId) {
        this.patronCategoryId = patronCategoryId;
    }

    public String getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(String isOnline) {
        this.isOnline = isOnline;
    }

    public String getOwns() {
        return owns;
    }

    public void setOwns(String owns) {
        this.owns = owns;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
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

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
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

    public String getPermanentAddress1() {
        return permanentAddress1;
    }

    public void setPermanentAddress1(String permanentAddress1) {
        this.permanentAddress1 = permanentAddress1;
    }

    public String getPermanentAddress2() {
        return permanentAddress2;
    }

    public void setPermanentAddress2(String permanentAddress2) {
        this.permanentAddress2 = permanentAddress2;
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

    public boolean commonEmail() {
        return commonEmail;
    }

    public void setCommonEmail(boolean commonEmail) {
        this.commonEmail = commonEmail;
    }

    public boolean commonInstantMsg() {
        return commonInstantMsg;
    }

    public void setCommonInstantMsg(boolean commonInstantMsg) {
        this.commonInstantMsg = commonInstantMsg;
    }

    public boolean commonPrint() {
        return commonPrint;
    }

    public void setCommonPrint(boolean commonPrint) {
        this.commonPrint = commonPrint;
    }

    public Date getEntryDate() {
        return entryDate;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSendToAddress() {
        return sendToAddress;
    }

    public void setSendToAddress(String sendToAddress) {
        this.sendToAddress = sendToAddress;
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
}
