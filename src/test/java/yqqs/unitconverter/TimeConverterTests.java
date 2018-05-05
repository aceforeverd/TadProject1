package yqqs.unitconverter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TimeConverterTests
{
    final double EPSILON = 0.0001;

    @Test
    public void testTimeExists()
    {
        TimeConverter testTimeConverter = new TimeConverter();
        assertNotNull(testTimeConverter);
    }

    @Test
    public void testTimeIsMeasurement()
    {
        TimeConverter testTimeConverter = new TimeConverter();
        assertTrue(testTimeConverter instanceof Converter);
    }

    @Test
    public void testTimeTypes()
    {
        String[] testTimeUnits = {
                "Milliseconds", "Seconds", "Minutes", "Hours", "Days", "Weeks", "Fortnights", "Years"
        };
        TimeConverter testTimeConverter = new TimeConverter();

        assertEquals(Arrays.asList(testTimeUnits), testTimeConverter.getUnits());
    }

    @Test
    public void testTimeToString()
    {
        TimeConverter testTimeConverter = new TimeConverter();
        assertEquals("Time", testTimeConverter.toString());
    }

    @Test
    public void testTimeConversionUnknownUnit() {
        String unit = "Hello";
        TimeConverter converter = new TimeConverter();
        Executable exec = () -> converter.getConversionFactor(unit);
        assertThrows(UnknownUnitException.class, exec, "Hello");
    }
    @Test
    public void testTimeConversionFactor1() throws Exception
    {
        String unit = "Seconds";
        double convFactor = 1.0;
        TimeConverter testTimeConverter = new TimeConverter();
        assertEquals(convFactor, testTimeConverter.getConversionFactor(unit));
    }

    @Test
    public void testTimeConversionFactor2() throws Exception
    {
        String unit = "Milliseconds";
        double convFactor = 1000.0;
        TimeConverter testTimeConverter = new TimeConverter();
        assertEquals(convFactor, testTimeConverter.getConversionFactor(unit));
    }

    @Test
    public void testTimeConversionFactor3() throws Exception
    {
        String unit = "Minutes";
        double convFactor = 1.0 / 60.0;
        TimeConverter testTimeConverter = new TimeConverter();
        assertEquals(convFactor, testTimeConverter.getConversionFactor(unit));
    }

    @Test
    public void testTimeConversionFactor4() throws Exception
    {
        String unit = "Hours";
        double convFactor = 1.0 / 3600.0;
        TimeConverter testTimeConverter = new TimeConverter();
        assertEquals(convFactor, testTimeConverter.getConversionFactor(unit));
    }

    @Test
    public void testTimeConversionFactor5() throws Exception
    {
        String unit = "Days";
        double convFactor = 1.0 / 86400.0;
        TimeConverter testTimeConverter = new TimeConverter();
        assertEquals(convFactor, testTimeConverter.getConversionFactor(unit));
    }

    @Test
    public void testTimeConversionFactor6() throws Exception
    {
        String unit = "Weeks";
        double convFactor = 1.0 / 604800.0;
        TimeConverter testTimeConverter = new TimeConverter();
        assertEquals(convFactor, testTimeConverter.getConversionFactor(unit));
    }

    @Test
    public void testTimeConversionFactor7() throws Exception
    {
        String unit = "Fortnights";
        double convFactor = 1.0 / 1209600.0;
        TimeConverter testTimeConverter = new TimeConverter();
        assertEquals(convFactor, testTimeConverter.getConversionFactor(unit));
    }

    @Test
    public void testTimeConversionFactor8() throws Exception
    {
        String unit = "Years";
        double convFactor = 1.0 / 31536000.0;
        TimeConverter testTimeConverter = new TimeConverter();
        assertEquals(convFactor, testTimeConverter.getConversionFactor(unit));
    }

    @Test
    public void testTimeConvertValueUnknown() {
        String currentUnit = "hello";
        String newUnit = "world";

        double currentValue = 12.0;
        double expectValue = 0.0;

        TimeConverter converter = new TimeConverter();
        assertEquals(converter.convertValue(currentUnit, currentValue, newUnit), expectValue);
    }

    @Test
    public void testTimeConvertValue1()
    {
        String currentUnit = "Years";
        String newUnit = "Days";
        double currentValue = 2.0;
        double expectedResult = 730.0;
        TimeConverter testTimeConverter = new TimeConverter();

        double newValue = testTimeConverter.convertValue(currentUnit, currentValue, newUnit);
        assertTrue(Math.abs(newValue - expectedResult) < EPSILON);
    }

    @Test
    public void testTimeConvertValue2()
    {
        String currentUnit = "Weeks";
        String newUnit = "Fortnights";
        double currentValue = 5.0;
        double expectedResult = 2.5;
        TimeConverter testTimeConverter = new TimeConverter();

        double newValue = testTimeConverter.convertValue(currentUnit, currentValue, newUnit);
        assertTrue(Math.abs(newValue - expectedResult) < EPSILON);
    }

    @Test
    public void testTimeConvertValue3()
    {
        String currentUnit = "Milliseconds";
        String newUnit = "Hours";
        double currentValue = 10000000.0;
        double expectedResult = 2.7778;
        TimeConverter testTimeConverter = new TimeConverter();

        double newValue = testTimeConverter.convertValue(currentUnit, currentValue, newUnit);
        assertTrue(Math.abs(newValue - expectedResult) < EPSILON);
    }
}
