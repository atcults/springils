package org.sanelib.ils.core.enums;

import java.util.HashMap;
import java.util.Map;

public enum AccessionSeriesType {
    Fixed ("Fixed", "A"),
    Variable ("Variable", "B");

	private final String name;
	private final String value;

    AccessionSeriesType(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

	public String getValue() {
		return this.value;
	}

	public String toString() {
		return this.name;
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
