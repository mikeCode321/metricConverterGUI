package convert.mass;

import java.util.HashMap;

import convert.BaseUnits;
import convert.TypeOfUnit;

public class Mass extends TypeOfUnit {

    private static BaseUnits lbsUnit = new Pounds();
    private static BaseUnits kgUnit = new KiloGram();

    public Mass() {
        super("Kilogram", new HashMap<String, BaseUnits>() {
            {
                put(lbsUnit.getName(), lbsUnit);
                put(kgUnit.getName(), kgUnit);
            }
        });
    }

    @Override
    public String getTypeOfUnit() {
        String typeOfUnit = "Mass";
        return typeOfUnit;
    }

}
