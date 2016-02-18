package org.sanelib.ils.core.enums;


import java.util.HashMap;
import java.util.Map;

public enum HolidayType {
    Repeated("R" , "Repeated"),
    Specific("S" , "Specific");

    private final String value;
    private final String name;

    HolidayType(String value,String name){
        this.value = value;
        this.name = name;
    }

    public boolean equalsName(String otherLabel) {
        return otherLabel != null && this.name.equals(otherLabel);
    }

    public String toString() {
        return this.value;
    }

    private static final Map<String, HolidayType> byName = new HashMap<>();
    private static final Map<String, HolidayType> byValue = new HashMap<>();

    static {
        for (HolidayType e : HolidayType.values()) {
            if (HolidayType.byName.put(e.name, e) != null) {
                throw new IllegalArgumentException("duplicate name: " + e.name);
            }
        }
        for (HolidayType e : HolidayType.values()) {
            if (HolidayType.byValue.put(e.value, e) != null) {
                throw new IllegalArgumentException("duplicate value: " + e.value);
            }
        }
    }

    public static HolidayType getByName(String name) {
        return HolidayType.byName.get(name);
    }

    public static HolidayType getByValue(String value) {
        return HolidayType.byValue.get(value);
    }
}
