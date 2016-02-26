package org.sanelib.ils.core.domain.entity;

import com.google.common.base.Strings;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "publishers")
public class Publisher implements DomainEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "pub_id")
    private String code;

    public String getCode() {
        return Strings.isNullOrEmpty(this.code) ? null : this.code.trim();
    }

    public void setCode(String code) {
        if (Strings.isNullOrEmpty(code) && !this.code.equals(code)) {
            throw new IllegalStateException("The CODE must not be changed after it is set.");
        }
        this.code = code.trim();
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
        return Strings.isNullOrEmpty(code) ? 0 : code.hashCode();
    }
}
