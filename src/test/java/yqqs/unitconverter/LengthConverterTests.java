package yqqs.unitconverter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class LengthConverterTests
{
    final double EPSILON = 0.0001;

    @Test
    public void testLengthExists()
    {
        LengthConverter testLengthConverter = new LengthConverter();
        assertNotNull(testLengthConverter);
    }

    @Test
    public void testLengthIsMeasurement()
    {
        LengthConverter testLengthConverter = new LengthConverter();
        assertTrue(testLengthConverter instanceof Converter);
    }

    @Test
    public void testLengthTypes()
    {
        String[] testLengthUnits = {
                "Millimeters", "Centimeters", "Meters", "Kilometers", "Inches", "Feet", "Yards", "Miles"
        };
        LengthConverter testLengthConverter = new LengthConverter();

        assertEquals(Arrays.asList(testLengthUnits), testLengthConverter.getUnits());
    }

    @Test
    public void testLengthToString()
    {
        LengthConverter testLengthConverter = new LengthConverter();
        assertEquals("Length", testLengthConverter.toString());
    }

    @Test
    public void testLengthConversionUnknownUnit() {
        String unit = "Hello";
        LengthConverter converter = new LengthConverter();
        Executable exec = () -> converter.getConversionFactor(unit);
        assertThrows(UnknownUnitException.class, exec, "Hello");
    }
    @Test
    public void testLengthConversionFactor1() throws Exception
    {
        String unit = "Meters";
        double convFactor = 1.0;
        LengthConverter testLengthConverter = new LengthConverter();
        assertEquals(convFactor, testLengthConverter.getConversionFactor(unit));
    }

    @Test
    public void testLengthConversionFactor2() throws Exception
    {
        String unit = "Millimeters";
        double convFactor = 1000.0;
        LengthConverter testLengthConverter = new LengthConverter();
        assertEquals(convFactor, testLengthConverter.getConversionFactor(unit));
    }

    @Test
    public void testLengthConversionFactor3() throws Exception
    {
        String unit = "Centimeters";
        double convFactor = 100.0;
        LengthConverter testLengthConverter = new LengthConverter();
        assertEquals(convFactor, testLengthConverter.getConversionFactor(unit));
    }

    @Test
    public void testLengthConversionFactor4() throws Exception
    {
        String unit = "Kilometers";
        double convFactor = 0.001;
        LengthConverter testLengthConverter = new LengthConverter();
        assertEquals(convFactor, testLengthConverter.getConversionFactor(unit));
    }

    @Test
    public void testLengthConversionFactor5() throws Exception
    {
        String unit = "Inches";
        double convFactor = 39.37;
        LengthConverter testLengthConverter = new LengthConverter();
        assertEquals(convFactor, testLengthConverter.getConversionFactor(unit));
    }

    @Test
    public void testLengthConversionFactor6() throws Exception
    {
        String unit = "Feet";
        double convFactor = 3.281;
        LengthConverter testLengthConverter = new LengthConverter();
        assertEquals(convFactor, testLengthConverter.getConversionFactor(unit));
    }

    @Test
    public void testLengthConversionFactor7() throws Exception
    {
        String unit = "Yards";
        double convFactor = 1.09361329;
        LengthConverter testLengthConverter = new LengthConverter();
        assertEquals(convFactor, testLengthConverter.getConversionFactor(unit));
    }

    @Test
    public void testLengthConversionFactor8() throws Exception
    {
        String unit = "Miles";
        double convFactor = 0.000621371;
        LengthConverter testLengthConverter = new LengthConverter();
        assertEquals(convFactor, testLengthConverter.getConversionFactor(unit));
    }

    @Test
    public void testLengthConvertValueInvalid() {
        String currentUnit = "hello";
        String newUnit = "world";

        double currentValue = 12.0;
        double expectValue = 0.0;

        LengthConverter converter = new LengthConverter();
        assertEquals(converter.convertValue(currentUnit, currentValue, newUnit), expectValue);
    }

    @Test
    public void testLengthConvertValue1()
    {
        String currentUnit = "Centimeters";
        String newUnit = "Millimeters";
        double currentValue = 40.0;
        double expectedResult = 400.0;
        LengthConverter testLengthConverter = new LengthConverter();

        double newValue = testLengthConverter.convertValue(currentUnit, currentValue, newUnit);
        assertTrue(Math.abs(newValue - expectedResult) < EPSILON);
    }

    @Test
    public void testLengthConvertValue2()
    {
        String currentUnit = "Yards";
        String newUnit = "Miles";
        double currentValue = 6000.0;
        double expectedResult = 3.409091;
        LengthConverter testLengthConverter = new LengthConverter();

        double newValue = testLengthConverter.convertValue(currentUnit, currentValue, newUnit);
        assertTrue(Math.abs(newValue - expectedResult) < EPSILON);
    }

    @Test
    public void testLengthConvertValue3()
    {
        String currentUnit = "Meters";
        String newUnit = "Inches";
        double currentValue = 3.0;
        double expectedResult = 118.11;
        LengthConverter testLengthConverter = new LengthConverter();

        double newValue = testLengthConverter.convertValue(currentUnit, currentValue, newUnit);
        assertTrue(Math.abs(newValue - expectedResult) < EPSILON);
    }
}
