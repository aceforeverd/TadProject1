package yqqs.unitconverter;

import java.util.ArrayList;
import java.util.Arrays;

public class LengthConverter implements Converter
{
    final String MILLIMETERS = "Millimeters";
    final String CENTIMETERS = "Centimeters";
    final String METERS = "Meters";
    final String KILOMETERS = "Kilometers";
    final String INCHES = "Inches";
    final String FEET = "Feet";
    final String YARDS = "Yards";
    final String MILES = "Miles";

    ArrayList<String> units;
    String[] lengthUnits = {
            MILLIMETERS, CENTIMETERS, METERS, KILOMETERS, INCHES, FEET, YARDS, MILES
    };

    public LengthConverter()
    {
        units = new ArrayList<>();
        units.addAll(Arrays.asList(lengthUnits));
    }

    @Override
    public ArrayList<String> getUnits()
    {
        return units;
    }

    @Override
    public double convertValue(String currentUnit, double currentValue, String newUnit)
    {
        double newValue = Double.NaN;

        try {
            newValue = currentValue * getConversionFactor(newUnit) / getConversionFactor(currentUnit);
        } catch (Exception e) {
            if (e instanceof UnknownUnitException) {
                System.out.printf(e.getMessage());
            }
            return 0.0;
        }

        return newValue;
    }

    @Override
    public String toString()
    {
        return "Length";
    }

    public double getConversionFactor(String unit) throws Exception
    {
        double conversionFactor = Double.NaN;

        if (unit.equals(METERS))
            conversionFactor = 1.0;
        else if (unit.equals(MILLIMETERS))
            conversionFactor = 1000.0;
        else if (unit.equals(CENTIMETERS))
            conversionFactor = 100.0;
        else if (unit.equals(KILOMETERS))
            conversionFactor = 0.001;
        else if (unit.equals(INCHES))
            conversionFactor = 39.37;
        else if (unit.equals(FEET))
            conversionFactor = 3.281;
        else if (unit.equals(YARDS))
            conversionFactor = 1.09361329;
        else if (unit.equals(MILES))
            conversionFactor = 0.000621371;
        else
            throw new UnknownUnitException(unit);

        return conversionFactor;
    }
}
