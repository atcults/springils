package org.sanelib.ils.core.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class AccessionSeriesTypeConverter implements AttributeConverter<AccessionSeriesType, String> {

    @Override
    public String convertToDatabaseColumn(AccessionSeriesType accessionSeriesType) {
        if ( accessionSeriesType == null ) {
            return null;
        }

        return accessionSeriesType.getValue();

    }

    @Override
    public AccessionSeriesType convertToEntityAttribute(String value) {
        if ( value == null ) {
            return null;
        }

        return AccessionSeriesType.getByValue( value );
    }
}
