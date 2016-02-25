package org.sanelib.ils.core.domain.entity;

import com.google.common.base.Strings;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authors")
public class Author implements DomainEntity{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "au_id")
    private String code;

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        if (Strings.isNullOrEmpty(code) && !this.code.equals(code)) {
            throw new IllegalStateException("The CODE must not be changed after it is set.");
        }
        this.code = code.trim();
    }

    @Column(name = "au_lname")
    private String lastName;

    @Column(name = "au_fname")
    private String firstName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zip")
    private String zipCode;

    @Column(name = "contract")
    private char isContract;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public boolean isContract() {
        return isContract == '1';
    }

    public void setContract(boolean contract) {
        this.isContract = contract ? '1' : '0';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return code.equals(author.code);
    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }
}
