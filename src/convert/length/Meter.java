package convert.length;

import convert.BaseUnits;

public class Meter extends BaseUnits{

    public Meter(){
        this.MULTIPLIER = 1.0;
    }

    @Override
    public String getName() {
        return "Meter";
    }
    
}
