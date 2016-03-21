package org.sanelib.ils.core.commands.library;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.domain.entity.Library;

public class AddLibrary implements ProcessCommand {

    private String name;
    private String city;
    private String state;
    private String country;

    @Override
    public Class getRootEntityClass() {
        return Library.class;
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

