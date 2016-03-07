package org.sanelib.ils.core.commands.author;

import org.sanelib.ils.core.commands.ProcessCommandWithCode;
import org.sanelib.ils.core.domain.entity.Author;

public class DeleteAuthor implements ProcessCommandWithCode {

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public Class getRootEntityClass() {
        return Author.class;
    }

    @Override
    public String getRootEntityName() {
        return "domain.entity.author";
    }
}
