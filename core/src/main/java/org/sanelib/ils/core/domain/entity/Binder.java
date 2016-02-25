package org.sanelib.ils.core.domain.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "cir_co_binder")
public class Binder implements DomainEntity {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private BinderId binderId;

    @Column(name = "binder_name")
    private String binderName;

    @Column(name = "address1")
    private String primaryAddress;

    @Column(name = "address2")
    private String secondaryAddress;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "pin")
    private String pin;

    @Column(name = "phone1")
    private String primaryPhoneNumber;

    @Column(name = "phone2")
    private String secondaryPhoneNumber;

    @Column(name = "fax")
    private String fax;

    @Column(name = "email")
    private String email;

    @Column(name = "entry_id")
    private String userCode;

    @Column(name = "entry_date")
    private Date entryDate;

    public BinderId getBinderId() {
        return binderId;
    }

    public void setBinderId(BinderId binderId) {
        this.binderId = binderId;
    }

    public void setBinderId(int id, int libraryId){
        if(this.binderId == null){
            this.binderId = new BinderId(libraryId, id);
        } else {
            this.binderId.setId(id);
            this.binderId.setLibraryId(libraryId);
        }
    }

    public String getBinderName() {
        return binderName;
    }

    public void setBinderName(String binderName) {
        this.binderName = binderName;
    }

    public String getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(String primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public String getSecondaryAddress() {
        return secondaryAddress;
    }

    public void setSecondaryAddress(String secondaryAddress) {
        this.secondaryAddress = secondaryAddress;
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

    public String getPrimaryPhoneNumber() {
        return primaryPhoneNumber;
    }

    public void setPrimaryPhoneNumber(String primaryPhoneNumber) {
        this.primaryPhoneNumber = primaryPhoneNumber;
    }

    public String getSecondaryPhoneNumber() {
        return secondaryPhoneNumber;
    }

    public void setSecondaryPhoneNumber(String secondaryPhoneNumber) {
        this.secondaryPhoneNumber = secondaryPhoneNumber;
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

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    @PrePersist
    public void prePersist() {
        entryDate = new Date();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Binder binder = (Binder) o;

        return binderId.equals(binder.binderId);

    }

    @Override
    public int hashCode() {
        return binderId.hashCode();
    }
}
