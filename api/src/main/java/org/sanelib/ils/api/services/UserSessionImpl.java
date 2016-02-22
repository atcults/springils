package org.sanelib.ils.api.services;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class UserSessionImpl implements UserSession {

    private String userCode;
    private Integer libraryId;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userId) {
        this.userCode = userId;
    }

    public Integer getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
    }

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
