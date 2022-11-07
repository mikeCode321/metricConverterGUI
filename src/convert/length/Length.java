package convert.length;

import java.util.HashMap;

import convert.BaseUnits;
import convert.TypeOfUnit;

public class Length extends TypeOfUnit {

    private static BaseUnits meterUnit = new Meter();
    private static BaseUnits footUnit = new Foot();
    private static BaseUnits inchUnit = new Inch();

    public Length() {
        super("Meter", new HashMap<String, BaseUnits>() {
            {
                put(meterUnit.getName(), meterUnit);
                put(footUnit.getName(), footUnit);
                put(inchUnit.getName(), inchUnit);
            }
        });
    }

    @Override
    public String getTypeOfUnit() {
        String typeOfUnit = "Length";
        return typeOfUnit;
    }

}
