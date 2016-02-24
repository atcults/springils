package org.sanelib.ils.core.enums;


import java.util.HashMap;
import java.util.Map;

public enum PatronType {

    StaffOfLibrary ("A", "Staff of Library"),
    Patron ("B", "Patron");

    private final String value;
    private final String name;

    PatronType(String value, String name) {
        this.name = name;
        this.value = value;
    }

    public boolean equalsName(String otherLabel) {
        return otherLabel != null && this.name.equals(otherLabel);
    }

    public String toString() {
        return this.value;
    }

    private static final Map<String, PatronType> byName = new HashMap<>();
    private static final Map<String, PatronType> byValue = new HashMap<>();

    static {
        for (PatronType e : PatronType.values()) {
            if (PatronType.byName.put(e.name, e) != null) {
                throw new IllegalArgumentException("duplicate name: " + e.name);
            }
        }
        for (PatronType e : PatronType.values()) {
            if (PatronType.byValue.put(e.value, e) != null) {
                throw new IllegalArgumentException("duplicate value: " + e.value);
            }
        }
    }

    public static PatronType getByName(String name) {
        return PatronType.byName.get(name);
    }

    public static PatronType getByValue(String value) {
        return PatronType.byValue.get(value);
    }
}
