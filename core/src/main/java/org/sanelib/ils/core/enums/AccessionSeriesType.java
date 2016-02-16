package org.sanelib.ils.core.enums;

import java.util.HashMap;
import java.util.Map;

public enum AccessionSeriesType {
    Fixed ("A", "Fixed"),
    Variable ("B", "Variable");

    private final String value;
    private final String name;

    AccessionSeriesType(String value, String name) {
        this.name = name;
        this.value = value;
    }

    public boolean equalsName(String otherLabel) {
        return otherLabel != null && this.name.equals(otherLabel);
    }

    public String toString() {
        return this.value;
    }

    private static final Map<String, AccessionSeriesType> byName = new HashMap<>();
    private static final Map<String, AccessionSeriesType> byValue = new HashMap<>();

    static {
        for (AccessionSeriesType e : AccessionSeriesType.values()) {
            if (AccessionSeriesType.byName.put(e.name, e) != null) {
                throw new IllegalArgumentException("duplicate name: " + e.name);
            }
        }
        for (AccessionSeriesType e : AccessionSeriesType.values()) {
            if (AccessionSeriesType.byValue.put(e.value, e) != null) {
                throw new IllegalArgumentException("duplicate value: " + e.value);
            }
        }
    }

    public static AccessionSeriesType getByName(String name) {
        return AccessionSeriesType.byName.get(name);
    }

    public static AccessionSeriesType getByValue(String value) {
        return AccessionSeriesType.byValue.get(value);
    }
}
