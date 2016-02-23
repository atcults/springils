package org.sanelib.ils.core.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "agency")
public class Agency implements DomainEntity {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private AgencyId agencyId;

	@Column(name = "agency_name")
	private String name;

    public AgencyId getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(int id, int libraryId){
        if(this.agencyId == null){
            this.agencyId = new AgencyId(libraryId, id);
        } else {
            this.agencyId.setId(id);
            this.agencyId.setLibraryId(libraryId);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Agency agency = (Agency) o;

        return agencyId.equals(agency.agencyId);

    }

    @Override
    public int hashCode() {
        return agencyId.hashCode();
    }
}
