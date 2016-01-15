package org.sanelib.ils.api.converters;

import com.google.common.base.Strings;
import org.sanelib.ils.api.dto.DtoWithCode;
import org.sanelib.ils.core.commands.ProcessCommandWithCode;
import org.sanelib.ils.core.exceptions.ProcessError;

public class ConverterHelper {

    public static void checkCodeRequired(DtoWithCode dto, ProcessCommandWithCode command, ProcessError processError){
        if(Strings.isNullOrEmpty(dto.getCode())){
            processError.addError("common.field.required", "code", "domain.common.code");
        } else {
            command.setCode(dto.getCode());
        }
    }

    public static boolean checkRequiredLength(String value, int len, String fieldKey, String labelName, ProcessError processError){
        if(!Strings.isNullOrEmpty(value) && value.length() > len){
            processError.addError("common.field.length", fieldKey, labelName, String.valueOf(len));
            return false;
        }
        return true;
    }
}
