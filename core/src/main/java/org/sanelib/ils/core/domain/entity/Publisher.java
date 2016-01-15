package org.sanelib.ils.core.domain.entity;

import com.google.common.base.Strings;

import javax.persistence.*;

@Entity
@Table(name = "publishers")
public class Publisher implements DomainEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "pub_id")
    private String id;

    public String getId() {
        return Strings.isNullOrEmpty(this.id) ? null : this.id.trim();
    }

    public void setId(String id) {
        if (Strings.isNullOrEmpty(id) && !this.id.equals(id)) {
            throw new IllegalStateException("The ID must not be changed after it is set.");
        }
        this.id = id.trim();
    }

	@Column(name = "pub_name")
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

    @Override
    public int hashCode() {
        return Strings.isNullOrEmpty(id) ? 0 : id.hashCode();
    }

}
