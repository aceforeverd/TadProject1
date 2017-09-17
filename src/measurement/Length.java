package measurement;

import java.util.ArrayList;
import java.util.Arrays;

public class Length implements Measurement
{
    ArrayList<String> units;
    String[] lengthUnits = {
            "Millimeters", "Centimeters", "Meters", "Kilometers", "Inches", "Feet", "Yards", "Miles"
    };

    public Length()
    {
        units = new ArrayList<String>();
        units.addAll(Arrays.asList(lengthUnits));
    }

    @Override
    public ArrayList<String> getUnits()
    {
        return units;
    }

    @Override
    public String toString()
    {
        return "Length";
    }

    public double getConversionFactor(String unit)
    {
        double conversionFactor = Double.NaN;

        if (unit.equals("Meters"))
            conversionFactor = 1.0;
        else if (unit.equals("Millimeters"))
            conversionFactor = 1000.0;
        else if (unit.equals("Centimeters"))
            conversionFactor = 100.0;
        else if (unit.equals("Kilometers"))
            conversionFactor = 0.001;
        else if (unit.equals("Inches"))
            conversionFactor = 39.3700787;
        else if (unit.equals("Feet"))
            conversionFactor = 3.280839895;
        else if (unit.equals("Yards"))
            conversionFactor = 1.09361329;
        else if (unit.equals("Miles"))
            conversionFactor = 0.000621371;

        return conversionFactor;
    }
}
