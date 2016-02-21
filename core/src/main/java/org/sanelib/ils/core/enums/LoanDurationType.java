package org.sanelib.ils.core.enums;


import java.util.HashMap;
import java.util.Map;

public enum LoanDurationType {
    Days("Day" , "days"),
    Hours("Hour" , "hours"),
    NextOccurring("NextOccurring", "NextOccurring");

    private final String value;
    private final String name;

    LoanDurationType(String value, String name){
        this.value = value;
        this.name = name;
    }

    public boolean equalsName(String otherLabel) {
        return otherLabel != null && this.name.equals(otherLabel);
    }

    public String toString() {
        return this.value;
    }

    private static final Map<String, LoanDurationType> byName = new HashMap<>();
    private static final Map<String, LoanDurationType> byValue = new HashMap<>();

    static {
        for (LoanDurationType e : LoanDurationType.values()) {
            if (LoanDurationType.byName.put(e.name, e) != null) {
                throw new IllegalArgumentException("duplicate name: " + e.name);
            }
        }
        for (LoanDurationType e : LoanDurationType.values()) {
            if (LoanDurationType.byValue.put(e.value, e) != null) {
                throw new IllegalArgumentException("duplicate value: " + e.value);
            }
        }
    }

    public static LoanDurationType getByName(String name) {
        return LoanDurationType.byName.get(name);
    }

    public static LoanDurationType getByValue(String value) {
        return LoanDurationType.byValue.get(value);
    }
}
