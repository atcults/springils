package org.sanelib.ils.core.domain.view.admin;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.sanelib.ils.core.domain.view.DomainView;
import org.sanelib.ils.core.domain.view.ViewWithId;

public class DepartmentView implements DomainView, ViewWithId {

    private Integer libraryId;
    private Integer id;
    private String deptName;
    private String hodId;

    public Integer getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getHodId() { return hodId; }

    public void setHodId(String hodId) { this.hodId = hodId; }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}


