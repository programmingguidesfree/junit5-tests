package org.pgf;

import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

@DisplayName("This class tests NumberTransformer class features")
public class NumberTransformerTest {
    private final NumberTransformer numberTransformer = new NumberTransformer();

    @BeforeAll
    static void beforeAll() {
        // do something here
    }

    @BeforeEach
    void beforeEach() {
        numberTransformer.setupCache();
    }

    @AfterAll
    static void afterAll() {
        // do something here
    }

    @AfterEach
    void afterEach() {
        numberTransformer.clearCache();
    }

    @Test
    void testDataCached() {
        assertTrue(numberTransformer.isDataCached());
    }

    @Test
    @DisplayName("We will test only allowed values here")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    @Tag("release-1.0")
    void testAllowedValues() {
        assertAll(
                () -> assertEquals("one", numberTransformer.transform(1)),
                () -> assertEquals("two", numberTransformer.transform(2)),
                () -> assertEquals("three", numberTransformer.transform(3))
        );
    }

    @Test
    void testZeroValue() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> numberTransformer.transform(0));
        assertEquals("Your number is negative, zero, or greater then or equal to 4", exception.getMessage());
    }

    @Test
    void testWhenNoDataCache() {
        assumeFalse(numberTransformer.isDataCached());

        // this code will only be executed if isDataCached() = false
    }

    @Disabled("It will implemented in coming sprint")
    @Test
    void testNewValue() {
        assertEquals("four", numberTransformer.transform(4));
    }

}
