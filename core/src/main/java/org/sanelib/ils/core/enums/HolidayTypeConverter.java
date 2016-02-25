package org.sanelib.ils.core.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class HolidayTypeConverter implements AttributeConverter<HolidayType , String>{

    @Override
    public String convertToDatabaseColumn(HolidayType holidayType) {
        if(holidayType == null){
            return null;
        }

        return holidayType.toString();
    }

    @Override
    public HolidayType convertToEntityAttribute(String value) {
        if( value == null){
            return null;
        }
        return HolidayType.getByValue(value);
    }
}
