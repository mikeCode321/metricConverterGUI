package convert.time;

import convert.BaseUnits;

public class Hour extends BaseUnits {

    public Hour(){
        this.MULTIPLIER = 3600.0;
    }

    @Override
    public String getName() {
        return "Hour";
    }
    
}