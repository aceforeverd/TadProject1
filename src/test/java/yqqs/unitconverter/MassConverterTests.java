package yqqs.unitconverter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class MassConverterTests
{
    final double EPSILON = 0.0001;

    @Test
    public void testMassExists()
    {
        MassConverter testMassConverter = new MassConverter();
        assertNotNull(testMassConverter);
    }

    @Test
    public void testMassIsMeasurement()
    {
        MassConverter testMassConverter = new MassConverter();
        assertTrue(testMassConverter instanceof Converter);
    }

    @Test
    public void testMassTypes()
    {
        String[] testMassUnits = {
                "Milligrams", "Grams", "Kilograms", "Tonnes", "Ounces", "Pounds-MassConverter", "Stones"
        };
        MassConverter testMassConverter = new MassConverter();

        assertEquals(Arrays.asList(testMassUnits), testMassConverter.getUnits());
    }

    @Test
    public void testMassToString()
    {
        MassConverter testMassConverter = new MassConverter();
        assertEquals("MassConverter", testMassConverter.toString());
    }

    @Test
    public void testMassConversionThrow() {
        String unit = "Hello";
        MassConverter massConverter = new MassConverter();
        Executable exec = () -> massConverter.getConversionFactor(unit);
        Assertions.assertThrows(UnknownUnitException.class, exec, "Hello");
    }

    @Test
    public void testMassConversionFactor1() throws Exception
    {
        String unit = "Kilograms";
        double convFactor = 1.0;
        MassConverter testMassConverter = new MassConverter();
        assertEquals(convFactor, testMassConverter.getConversionFactor(unit));
    }

    @Test
    public void testMassConversionFactor2() throws Exception
    {
        String unit = "Milligrams";
        double convFactor = 1000000.0;
        MassConverter testMassConverter = new MassConverter();
        assertEquals(convFactor, testMassConverter.getConversionFactor(unit));
    }

    @Test
    public void testMassConversionFactor3() throws UnknownUnitException
    {
        String unit = "Grams";
        double convFactor = 1000.0;
        MassConverter testMassConverter = new MassConverter();
        assertEquals(convFactor, testMassConverter.getConversionFactor(unit));
    }

    @Test
    public void testMassConversionFactor4() throws UnknownUnitException
    {
        String unit = "Tonnes";
        double convFactor = 0.001;
        MassConverter testMassConverter = new MassConverter();
        assertEquals(convFactor, testMassConverter.getConversionFactor(unit));
    }

    @Test
    public void testMassConversionFactor5() throws UnknownUnitException
    {
        String unit = "Ounces";
        double convFactor = 35.274;
        MassConverter testMassConverter = new MassConverter();
        assertEquals(convFactor, testMassConverter.getConversionFactor(unit));
    }

    @Test
    public void testMassConversionFactor6() throws UnknownUnitException
    {
        String unit = "Pounds-MassConverter";
        double convFactor = 2.20462;
        MassConverter testMassConverter = new MassConverter();
        assertEquals(convFactor, testMassConverter.getConversionFactor(unit));
    }

    @Test
    public void testMassConversionFactor7() throws UnknownUnitException
    {
        String unit = "Stones";
        double convFactor = 0.1575;
        MassConverter testMassConverter = new MassConverter();
        assertEquals(convFactor, testMassConverter.getConversionFactor(unit));
    }

    @Test
    public void testMassConvertValueUnknown() {
        String currentUnit = "hello";
        String newUnit = "world";

        double currentValue = 12.0;
        double expectValue = 0.0;

        MassConverter converter = new MassConverter();
        assertEquals(converter.convertValue(currentUnit, currentValue, newUnit), expectValue);
    }

    @Test
    public void testMassConvertValue1()
    {
        String currentUnit = "Milligrams";
        String newUnit = "Grams";
        double currentValue = 4.0;
        double expectedResult = 0.004;
        MassConverter testMassConverter = new MassConverter();

        double newValue = testMassConverter.convertValue(currentUnit, currentValue, newUnit);
        assertTrue(Math.abs(newValue - expectedResult) < EPSILON);
    }

    @Test
    public void testMassConvertValue2()
    {
        String currentUnit = "Stones";
        String newUnit = "Pounds-MassConverter";
        double currentValue = 5.0;
        double expectedResult = 69.9879;
        MassConverter testMassConverter = new MassConverter();

        double newValue = testMassConverter.convertValue(currentUnit, currentValue, newUnit);
        assertTrue(Math.abs(newValue - expectedResult) < EPSILON);
    }

    @Test
    public void testMassConvertValue3()
    {
        String currentUnit = "Ounces";
        String newUnit = "Tonnes";
        double currentValue = 15000.0;
        double expectedResult = 0.42524;
        MassConverter testMassConverter = new MassConverter();

        double newValue = testMassConverter.convertValue(currentUnit, currentValue, newUnit);
        assertTrue(Math.abs(newValue - expectedResult) < EPSILON);
    }
}
