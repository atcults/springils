package org.sanelib.ils.core.enums;


import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class PatronTypeConverter implements AttributeConverter<PatronType, String> {

    @Override
    public String convertToDatabaseColumn(PatronType patronType) {
        if ( patronType == null ) {
            return null;
        }

        return patronType.toString();

    }

    @Override
    public PatronType convertToEntityAttribute(String value) {
        if ( value == null ) {
            return null;
        }

        return PatronType.getByValue( value );
    }

}
