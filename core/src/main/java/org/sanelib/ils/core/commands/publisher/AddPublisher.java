package org.sanelib.ils.core.commands.publisher;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.sanelib.ils.core.commands.ProcessCommandWithCode;
import org.sanelib.ils.core.domain.entity.Publisher;

public class AddPublisher implements ProcessCommandWithCode {

    private String code;
    private String name;
    private String city;
    private String state;
    private String country;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public Class getRootEntityClass() {
        return Publisher.class;
    }

    @Override
    public String getRootEntityName() {
        return "domain.entity.publisher";
    }

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
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}

