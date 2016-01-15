package org.sanelib.ils.core.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public final boolean isPersisted() {
        return id == 0;
    }

    @Override
    public int hashCode() {
        return this.id;
    }

}
