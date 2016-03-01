package org.sanelib.ils.core.commands;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public abstract class ProcessAuditCommandWithLibraryId extends ProcessCommandWithLibraryId {

    private String userCode;
    private Integer userLibraryId;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public Integer getUserLibraryId() {
        return userLibraryId;
    }

    public void setUserLibraryId(Integer userLibraryId) {
        this.userLibraryId = userLibraryId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
