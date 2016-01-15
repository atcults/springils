package org.sanelib.ils.core.commands.publisher;

import org.sanelib.ils.core.commands.ProcessCommandWithCode;
import org.sanelib.ils.core.domain.entity.Publisher;

public class DeletePublisher implements ProcessCommandWithCode {

    private String code;

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
}
