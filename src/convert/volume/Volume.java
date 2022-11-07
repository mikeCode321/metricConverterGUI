package convert.volume;

import java.util.HashMap;

import convert.BaseUnits;
import convert.TypeOfUnit;

public class Volume extends TypeOfUnit {

    private static BaseUnits literUnit = new Liter();
    private static BaseUnits gallonUnit = new Gallon();
    private static BaseUnits ouncesUnit = new Ounces();

    public Volume() {
        super("Liter", new HashMap<String, BaseUnits>() {
            {
                put(literUnit.getName(), literUnit);
                put(gallonUnit.getName(), gallonUnit);
                put(ouncesUnit.getName(), ouncesUnit);
            }
        });
    }

    @Override
    public String getTypeOfUnit() {
        String typeOfUnit = "Volume";
        return typeOfUnit;
    }

}
