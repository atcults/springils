package org.sanelib.ils.core.commands.binder;

import org.sanelib.ils.core.commands.ProcessAuditCommandWithLibraryId;
import org.sanelib.ils.core.domain.entity.Binder;

public class AddBinder extends ProcessAuditCommandWithLibraryId {
    @Override
    public Class getRootEntityClass() {
        return Binder.class;
    }

    @Override
    public String getRootEntityName() {
        return "domain.entity.binder";
    }

    private String name;
    private String primaryAddress;
    private String secondaryAddress;
    private String city;
    private String state;
    private String country;
    private String pin;
    private String primaryPhone;
    private String secondaryPhone;
    private String fax;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPrimaryPhone() {
        return primaryPhone;
    }

    public void setPrimaryPhone(String primaryPhone) {
        this.primaryPhone = primaryPhone;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
