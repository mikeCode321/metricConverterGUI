package convert.time;

import java.util.HashMap;

import convert.BaseUnits;
import convert.TypeOfUnit;

public class Time extends TypeOfUnit {

    private static BaseUnits hourUnit = new Hour();
    private static BaseUnits minuteUnit = new Minute();
    private static BaseUnits secondsUnit = new Seconds();

    public Time() {
        super("Seconds", new HashMap<String, BaseUnits>() {
            {
                put(hourUnit.getName(), hourUnit);
                put(minuteUnit.getName(), minuteUnit);
                put(secondsUnit.getName(), secondsUnit);
            }
        });
    }

    @Override
    public String getTypeOfUnit() {
        String typeOfUnit = "Time";
        return typeOfUnit;
    }

}

