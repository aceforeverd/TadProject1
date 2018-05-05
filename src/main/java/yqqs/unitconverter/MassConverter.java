package yqqs.unitconverter;

import java.util.ArrayList;
import java.util.Arrays;

public class MassConverter implements Converter
{
    final String MILLIGRAMS = "Milligrams";
    final String GRAMS = "Grams";
    final String KILOGRAMS = "Kilograms";
    final String TONNES = "Tonnes";
    final String OUNCES = "Ounces";
    final String POUNDSMASS = "Pounds-MassConverter";
    final String STONES = "Stones";

    ArrayList<String> units;
    String[] massUnits = {
            MILLIGRAMS, GRAMS, KILOGRAMS, TONNES, OUNCES, POUNDSMASS, STONES
    };

    public MassConverter()
    {
        units = new ArrayList<>();
        units.addAll(Arrays.asList(massUnits));
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
        } catch (UnknownUnitException e) {
            System.out.printf(e.getMessage());
            return 0.0;
        }

        return newValue;
    }

    @Override
    public String toString()
    {
        return "MassConverter";
    }

    public double getConversionFactor(String unit) throws UnknownUnitException
    {
        double conversionFactor = Double.NaN;

        if (unit.equals(KILOGRAMS))
            conversionFactor = 1.0;
        else if (unit.equals(MILLIGRAMS))
            conversionFactor = 1000000.0;
        else if (unit.equals(GRAMS))
            conversionFactor = 1000.0;
        else if (unit.equals(TONNES))
            conversionFactor = 0.001;
        else if (unit.equals(OUNCES))
            conversionFactor = 35.274;
        else if (unit.equals(POUNDSMASS))
            conversionFactor = 2.20462;
        else if (unit.equals(STONES))
            conversionFactor = 0.1575;
        else
            throw new UnknownUnitException(unit);

        return conversionFactor;
    }
}
