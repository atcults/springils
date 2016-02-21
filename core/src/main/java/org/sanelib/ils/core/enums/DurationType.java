package org.sanelib.ils.core.enums;


import java.util.HashMap;
import java.util.Map;

public enum DurationType {
    Days("Day" , "days"),
    Hours("Hour" , "hours"),
    Fixed("NextOccurring", "NextOccurring");

    private final String value;
    private final String name;

    DurationType(String value, String name){
        this.value = value;
        this.name = name;
    }

    public String getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.value;
    }

    private static final Map<String, DurationType> byName = new HashMap<>();
    private static final Map<String, DurationType> byValue = new HashMap<>();

    static {
        for (DurationType e : DurationType.values()) {
            if (DurationType.byName.put(e.name, e) != null) {
                throw new IllegalArgumentException("duplicate name: " + e.name);
            }
        }
        for (DurationType e : DurationType.values()) {
            if (DurationType.byValue.put(e.value, e) != null) {
                throw new IllegalArgumentException("duplicate value: " + e.value);
            }
        }
    }

    public static DurationType getByName(String name) {
        return DurationType.byName.get(name);
    }

    public static DurationType getByValue(String value) {
        return DurationType.byValue.get(value);
    }
}
