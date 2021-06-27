package org.pgf;

import java.util.AbstractMap;
import java.util.Map;

public class NumberTransformer {
    private boolean isDataCached = false;

    // if your Java version is 9 or higher use this code:
    private static final Map<Integer, String> TRANSFORMATION_MAP = Map.ofEntries(
            new AbstractMap.SimpleEntry<>(1, "one"),
            new AbstractMap.SimpleEntry<>(2, "two"),
            new AbstractMap.SimpleEntry<>(3, "three")
    );

    // if your Java version is 8 or lower (it can be used in Java 9 or higher too)
    // private final static Map<Integer, String> TRANSFORMATION_MAP;
    // static {
    //    TRANSFORMATION_MAP = new HashMap<>();
    //    TRANSFORMATION_MAP.put(1, "one");
    //    TRANSFORMATION_MAP.put(2, "two");
    //    TRANSFORMATION_MAP.put(3, "three");
    //}

    public String transform(int number) {
        if (number <= 0 || number >= 4) {
            throw new IllegalArgumentException("Your number is negative, zero, or greater then or equal to 4");
        }

        return TRANSFORMATION_MAP.get(number);
    }

    public void setupCache() {
        // created just for testing purposes
        isDataCached = true;
        System.out.println("called: setupCache()");
    }

    public void clearCache() {
        // created just for testing purposes
        isDataCached = false;
        System.out.println("called: clearCache()");
    }

    public boolean isDataCached() {
        return isDataCached;
    }

}
