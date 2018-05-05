package yqqs.unitconverter;

import java.util.ArrayList;

public interface Converter
{
    public ArrayList<String> getUnits();
    public double convertValue(String currentUnit, double currentValue, String newUnit);
}
