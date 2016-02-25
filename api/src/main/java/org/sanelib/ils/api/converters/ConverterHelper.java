package org.sanelib.ils.api.converters;

import com.google.common.base.Strings;
import org.sanelib.ils.api.dto.DtoWithCode;
import org.sanelib.ils.api.dto.DtoWithId;
import org.sanelib.ils.api.dto.DtoWithLibraryId;
import org.sanelib.ils.common.utils.RegularExpressionHelper;
import org.sanelib.ils.core.commands.ProcessCommandWithCode;
import org.sanelib.ils.core.commands.ProcessCommandWithId;
import org.sanelib.ils.core.commands.ProcessCommandWithLibraryId;
import org.sanelib.ils.core.exceptions.ProcessError;

import java.util.Objects;

public class ConverterHelper {

    public static void checkIdRequired(DtoWithId dto, ProcessCommandWithId command, ProcessError processError){
        if(Strings.isNullOrEmpty(dto.getId())){
            processError.addError("common.field.required", "id", "domain.common.id");
        }
        else if(!RegularExpressionHelper.checkIdFormat(dto.getId())){
            processError.addError("common.field.pattern", "id", "domain.common.id", RegularExpressionHelper.ID_FORMAT);
        } else {
            command.setId(Integer.parseInt(dto.getId()));
        }
    }

    public static void checkLibraryIdRequired(DtoWithLibraryId dto, ProcessCommandWithLibraryId command, ProcessError processError){
        if(Strings.isNullOrEmpty(dto.getLibraryId())){
            processError.addError("common.field.required", "libraryId", "domain.common.libraryId");
        }
        else if(!RegularExpressionHelper.checkIdFormat(dto.getLibraryId())){
            processError.addError("common.field.pattern", "libraryId", "domain.common.libraryId", RegularExpressionHelper.ID_FORMAT);
        } else {
            command.setLibraryId(Integer.parseInt(dto.getLibraryId()));
        }
    }

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

    public static Integer checkOptionalInteger(String fieldName, String value, String labelName, ProcessError processError){

        Integer intValue = null;

        if ((Objects.equals(value, "")) || (!Strings.isNullOrEmpty(value) && !RegularExpressionHelper.checkNumber(value))) {
            processError.addError("common.field.invalidInteger", fieldName, labelName);
        } else if (value != null) {
            intValue = Integer.parseInt(value);
        }

        return intValue;
    }

    public static Integer checkOptionalPositiveInteger(String fieldName, String value, String labelName, int minValue, ProcessError processError){

        Integer intValue = checkOptionalInteger(fieldName, value, labelName, processError);

        if(intValue != null && intValue < minValue){
            intValue = null;
            processError.addError("common.field.shouldBeGraterOrEqualThan", fieldName, labelName, String.valueOf(minValue));
        }

        return intValue;
    }
}
